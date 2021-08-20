package org.report.naive.common;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ObjectTest {

    @Test
    public void objectTest() throws IOException, ClassNotFoundException {
        String test = "test";
        Assert.assertEquals(ObjectUtils.bytesToObject(ObjectUtils.objectToBytes(test)), test);
    }

}
