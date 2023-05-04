package org.open.lang.ms.note.api.module.exam;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExamCondition {

    private DateRange dateRange;

    private Date dateStart;
    private Date dateEnd;

    private String itemType;

    private String createUser;

    public enum DateRange{
        ALL,
        TODAY,
        YESTERDAY,
        WEEK_INNER,
        WEEK_OUTER
    }


}
