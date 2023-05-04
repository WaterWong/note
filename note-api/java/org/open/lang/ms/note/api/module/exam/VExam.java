package org.open.lang.ms.note.api.module.exam;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.base.bean.IEntity;

import java.io.Serial;

@TableName("v_exam")
@Getter
@Setter
public class VExam implements IEntity<String> {

    @Serial
    private static final long serialVersionUID = 5853988512027361051L;

    private String id;
    private String name;
    private Integer count;
    private Integer score;


}
