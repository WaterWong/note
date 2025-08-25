package org.open.lang.ms.note.api.module.items.item;

import org.junit.jupiter.api.Test;
import org.soul.base.lang.string.StringTool;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceImplTest {

    @Test
    void test_replace(){
        String s = " a b c ";
        s = s.replaceAll("^\\s*","").replaceAll("\\s*$","");
        assert s.equals("a b c");

        s = "　 a b c　 ";
        s = s.replaceAll("^[\\s|　]*","").replaceAll("[\\s|　]*$","");
        assert s.equals("a b c");
    }

}