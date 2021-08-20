package org.report.naive.common;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {

    @Test
    public void stringTest() {
        Assert.assertTrue(StringUtils.isBlank("    "));
    }

}
