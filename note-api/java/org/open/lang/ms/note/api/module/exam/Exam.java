package org.open.lang.ms.note.api.module.exam;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;
import java.util.*;

import java.io.Serial;

@TableName("exam")
public class Exam extends BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 5853988512027361051L;
    /** 测验标题*/
    public final static String FIELD_NAME = "name";
    @TableId(type= IdType.ASSIGN_ID)
    private String id;

    /** 测验标题*/
    private String name;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
