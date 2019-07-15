package com.ljxt.chapter3;

/**
 * @ClassName: Test4
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 10:18
 * @Version: 1.0
 */
public class Test4 {
    public static void main(String[] args) {
        byte testByte = 1;
        short testShort = 1;
        long testLong = 1L;
        float testFloat = 1f;
        String testString = "a";
        char testChar = 'a';
        switch (testChar) {
            case 'a':
                System.out.println("可以");
                break;
            default:
                System.out.println("不匹配");
                break;
        }
        // switch支持的有：char、byte、short、int 和
        // Character、Byte、Short、Integer 、String 和 enum
    }
}
