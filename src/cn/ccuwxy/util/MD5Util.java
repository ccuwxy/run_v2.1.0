package cn.ccuwxy.util;

import java.security.MessageDigest;

public class MD5Util {
    public static String xtMD5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(Integer.toHexString(i));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        }
    }
    public static String getXTCode(long j, String str, String str2, String str3) {
        String str4 = "";
        byte[] bArr = new byte[8];
        str4 = "";
        str4 = "";
        str4 = "";
        try {
            byte[] bytes = xtMD5(j + str + str3 + "stlchang").getBytes("UTF-8");
            if (bytes.length < 32) {
                return "";
            }
            bArr[0] = bytes[7];
            bArr[1] = bytes[3];
            bArr[2] = bytes[15];
            bArr[3] = bytes[24];
            bArr[4] = bytes[9];
            bArr[5] = bytes[17];
            bArr[6] = bytes[29];
            bArr[7] = bytes[23];
            try {
                return new String(bArr, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
