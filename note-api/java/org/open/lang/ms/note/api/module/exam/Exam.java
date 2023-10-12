package org.open.lang.ms.note.api.module.exam;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;
import java.util.*;

import java.io.Serial;

@Schema(description = "试验模型")
@TableName("exam")
@Setter
@Getter
public class Exam extends BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 5853988512027361051L;

    public final static String FIELD_NAME = "name";

    @Schema(description = "主键")
    @TableId(type= IdType.ASSIGN_ID)
    private String id;

    /** */
    @Schema(description = "测验标题")
    private String name;

}
