package org.open.lang.ms.note.api.module.exam.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.soul.ability.data.rdb.mybatis.entity.BaseEntity;
import java.util.*;

import java.io.Serial;

@TableName("exam_log")
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
    public final static String FIELD_ORIGIN = "origin";
    /** 译文*/
    public final static String FIELD_TRANSLATE = "translate";
    /** 答案*/
    public final static String FIELD_ANSWER = "answer";
    @TableId(type= IdType.AUTO)
    private String id;

    /** */
    private String examId;
    /** */
    private String itemId;
    /** 詞條数量*/
    private Boolean result;
    /** 原文*/
    private String origin;
    /** 译文*/
    private String translate;
    /** 答案*/
    private String answer;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
