package org.open.lang.ms.note.api.module.items.log;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.soul.ability.data.rdb.mybatis.imapper.IBaseCrudMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ItemLogMapper extends IBaseCrudMapper<ItemLog, String> {

    @Select("""
             select log_type as logType,count(1) as count
             from item_log t 
             where 1 = 1
                and t.item_id = #{itemId} 
                and create_user_id = #{createUserId}
             group by  log_type;
            """)
    List<Map<String,Integer>> statByItemIdAndCreateUserId(@Param("itemId") String itemId, @Param("createUserId") String createUserId);
}
