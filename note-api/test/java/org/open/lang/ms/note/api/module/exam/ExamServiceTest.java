package org.open.lang.ms.note.api.module.exam;

import org.junit.jupiter.api.Test;
import org.soul.base.bean.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class ExamServiceTest {

    private ExamService examService = new ExamService();

    @Test
    void calcDate() {
        Pair rs = examService.calcDate(-1,0);
        System.out.println(rs);
    }
}