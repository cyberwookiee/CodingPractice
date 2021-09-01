package com.brymanco.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.brymanco.strings.StringAlgs;

public class StringAlgTests {

    @Test
    public void verifyRemoveDups() {

        char[] str = "ababababab".toCharArray();

        int end = StringAlgs.removeDups(str);

        Assertions.assertEquals("ab", new String(str, 0, end));

    }

}
