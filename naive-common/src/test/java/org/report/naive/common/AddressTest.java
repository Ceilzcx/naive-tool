package org.report.naive.common;

import org.junit.Assert;
import org.junit.Test;

import java.net.SocketException;
import java.net.UnknownHostException;

public class AddressTest {

    @Test
    public void addressTest() throws SocketException, UnknownHostException {
        Assert.assertNotNull(AddressUtils.getLocalAddress());
    }

}
