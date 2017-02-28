package edu.hlju.boler.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jing Qingyun 使用MD5对密码进行单向加密，生成32位十六进制字符的密码
 */
public class Encrytor {

    /**
     * @param 将要加密的密码字符串
     * @return 返回加密处理后的32位密文，加密失败返回空字符串
     */
    public static String encrypt(String message) {
        if (message == null || message.equals(""))
            return "";
        try {
            MessageDigest sha1 = MessageDigest.getInstance("sha1");
            byte[] data = message.getBytes();
            // 通过Java提供的工具获得16字节MD5算法生成的密码
            sha1.update(data);
            return toHexString(sha1.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(Encrytor.encrypt("Qingyun3075833").length());
    }

    private static String toHexString(byte[] data) {
        final char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            /*
             * 对于形如0xf0这样的十六进制数来说，f是高位，0是低位。
             * 在转换为字符串时，以两个字符对应一个byte，所以需要先存byte的高位，即一对字符中的前一个
             * byte类型与十六进制按位与之后结果为十进制数，再从hexChar选择对应的十六进制码
             */
            sb.append(hexChar[(b & 0xf0) >>> 4]);
            sb.append(hexChar[b & 0x0f]);
        }
        return sb.toString();
    }

}
