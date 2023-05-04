package org.open.lang.ms.note.api.module.exam.log;

import org.open.lang.ms.note.api.module.exam.vo.ExamLogQueryModel;
import org.springframework.stereotype.Component;
import org.soul.base.bean.Pair;
import org.soul.base.query.Criteria;
import org.soul.base.query.sort.Order;
import org.soul.base.support.model.common.BasePagingModel;
import org.soul.ability.data.rdb.mybatis.service.BaseCrudService;



@Component
public class ExamLogService extends BaseCrudService<ExamLog, ExamLogMapper, String> implements IExamLogService {

    @Override
    protected Pair<Criteria, Order[]> pagingCriteria(BasePagingModel pagingModel) {
        ExamLogQueryModel queryVo = (ExamLogQueryModel) pagingModel;

        Criteria criteria = new Criteria();
//        if (StringTool.isNotBlank(queryVo.getName())) {
//            criteria.addAnd("xxx", Operator.LIKE, queryVo.getName());
//        }
        return new Pair<>(criteria, null);
    }

}