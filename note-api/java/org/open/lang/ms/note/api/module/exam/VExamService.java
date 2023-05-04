package org.open.lang.ms.note.api.module.exam;

import org.soul.ability.data.rdb.mybatis.service.BaseReadOnlyService;
import org.soul.base.bean.Pair;
import org.soul.base.query.Criteria;
import org.soul.base.query.enums.OperatorEnum;
import org.soul.base.query.result.Paging;
import org.soul.base.query.sort.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class VExamService extends BaseReadOnlyService<VExam, VExamMapper, String> implements IVExamService {

    @Override
    public List<VExam> list(String createUserId) {

        Criteria criteria = Criteria.add(
                Exam.FIELD_CREATE_USER_ID, OperatorEnum.EQ, createUserId
        );
        Pair<List<VExam>, Paging> listPagingPair = mapper.pagingSearch(criteria, 0, 9, Order.desc(Exam.FIELD_CREATE_TIME));
        return null;
    }
}