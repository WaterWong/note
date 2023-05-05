package org.open.lang.ms.note.api.module.exam.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;

import java.io.Serial;

@TableName("exam_log")
@Getter
@Setter
public class ExamLog extends BaseEntity<String> {

    @Serial
    private static final long serialVersionUID = 5853988512027361051L;
    /** */
    public final static String FIELD_EXAM_ID = "examId";
    /** */
    public final static String FIELD_ITEM_ID = "itemId";
    /** 詞條数量*/
    public final static String FIELD_RESULT = "result";
    /** 原文*/
    public final static String FIELD_QUESTION = "question";

    /** 答案*/
    public final static String FIELD_ANSWER = "answer";
    @TableId(type= IdType.ASSIGN_ID)
    private String id;

    /** */
    private String examId;
    /** */
    private String itemId;
    /** 詞條数量*/
    private Boolean result;
    /** 原文*/
    private String question;

    /** 答案*/
    private String answer;

}
