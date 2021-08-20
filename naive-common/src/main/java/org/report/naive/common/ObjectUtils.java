package org.report.naive.common;

import java.io.*;

public class ObjectUtils {
    private ObjectUtils() {}

    public static byte[] objectToBytes(Object obj) throws IOException {
        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(obj);
            oos.flush();
            return bos.toByteArray();
        }
    }

    public static Object bytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        try (
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bis)
        ) {
            return ois.readObject();
        }
    }


}
