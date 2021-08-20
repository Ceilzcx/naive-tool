package org.report.naive.common;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class AddressUtils {
    private AddressUtils() {
    }

    public static String getLocalAddress() throws SocketException, UnknownHostException {
        String os = System.getProperty("os.name");
        if (os.startsWith("win")) {
            return InetAddress.getLocalHost().getHostAddress();
        }
        // 其他默认为linux
        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
            NetworkInterface networkInterface = en.nextElement();
            String name = networkInterface.getName();
            if (name.contains("docker") || name.contains("lo")) {
                continue;
            }
            for (Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                InetAddress inetAddress = enumIpAddr.nextElement();
                if (inetAddress.isLoopbackAddress()) {
                    continue;
                }
                String ipAddress = inetAddress.getHostAddress();
                if (!ipAddress.contains("::") && !ipAddress.contains("fe80") && !ipAddress.contains("0:0:")) {
                    return ipAddress;
                }
            }
        }
        return null;
    }

}
