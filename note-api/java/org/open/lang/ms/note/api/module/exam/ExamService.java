package org.open.lang.ms.note.api.module.exam;

import org.open.lang.ms.note.api.module.exam.log.ExamLogMapper;
import org.open.lang.ms.note.api.module.items.item.Item;
import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;
import org.soul.base.bean.Pair;
import org.soul.base.lang.collections.CollectionTool;
import org.soul.base.query.Criteria;
import org.soul.base.query.enums.OperatorEnum;
import org.soul.base.query.result.Paging;
import org.soul.base.query.sort.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class ExamService extends BaseCrudService<Exam, ExamMapper, String> implements IExamService {

    private ConcurrentHashMap<String,List<Item>> items = new ConcurrentHashMap();

    @Autowired
    private ExamLogMapper examLogMapper;

    @Override
    public List<Exam> list(String createUserId) {

        Criteria criteria = Criteria.add(
                Exam.FIELD_CREATE_USER_ID, OperatorEnum.EQ, createUserId
        );
        Pair<List<Exam>, Paging> listPagingPair = mapper.pagingSearch(criteria, 0, 9, Order.desc(Exam.FIELD_CREATE_TIME));
        return null;
    }


    public Item generate(ExamCondition examCondition) {
        Pair<Date,Date> duration = null;
        switch (examCondition.getDateRange()) {
            //0: 当前时刻 -1: 昨天0点
            case ALL        -> duration = calcDate(-365,1);
            case TODAY      -> duration = calcDate( 0,1);
            case YESTERDAY  -> duration = calcDate( -1,0);
            case WEEK_INNER -> duration = calcDate( -7,1);
            case WEEK_OUTER -> duration = calcDate(-365,-7);
        }

        examCondition.setDateStart(duration.getKey());
        examCondition.setDateEnd(duration.getValue());
        List<Item> cache = items.get(examCondition.getCreateUser());
        if (CollectionTool.isNotEmpty(cache)) {
            return cache.remove(0);
        }

        List<Item> items =  mapper.generate(examCondition);
        if (items.size() > 0 ) {
            Item item = items.remove(0);
            this.items.put(examCondition.getCreateUser(),items);
            return item;
        }
        return null;
    }

    protected Pair calcDate(int start, int end) {
        Instant now = Instant.now().truncatedTo(ChronoUnit.DAYS);
        Date dateStart = new Date(now.plus(Duration.ofDays(start)).toEpochMilli());
        Date dateEnd   = new Date(now.plus(Duration.ofDays(end)).toEpochMilli());
        return new Pair(dateStart,dateEnd);
    }
}