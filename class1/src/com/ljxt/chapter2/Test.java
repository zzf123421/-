package com.ljxt.chapter2;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/12 20:59
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception{
        int i = 1;
        int j = i++ * 2 + 3 * i++;
        System.out.println(j);
        int a = 1;
        int b = 2;
        System.out.printf("a++：%d，a++ + b：%d，a：%d\n",a++,a++ + b,a);
        System.out.println("abc\b123");
        System.out.println(-5 % 2);
        System.out.println(-5 % -2);
        System.out.println(5 % 2);
        System.out.println(5 % -2);
        System.out.println(5 % 2.3);
        switch (2) {
            case 1:
                System.out.println(1);
                break;
            default:
                System.out.println("default");
                break;
            case 3:
                System.out.println(2);
        }
        System.out.printf("%o");
    }
}
