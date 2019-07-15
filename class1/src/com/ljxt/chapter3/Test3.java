package com.ljxt.chapter3;

import java.util.Scanner;

/**
 * @ClassName: Test3
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 09:45
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println("请输入不大于5位的正整数：");
        int input = new Scanner(System.in).nextInt();
        //存放位数的字符串数组
        String[] digit = {"个位","十位","百位","千位","万位"};
        for (int i = 0;i < 5;i++) {
            //用format拼接字符串
            String message = String.format("输入数字的" + digit[i] + "是：");
            System.out.println(message + input % 10);
            //相当于让input右移一位，去掉末位数字
            input /= 10;
            //判断数字有几位
            if (input == 0) {
                System.out.printf("输入数字是%d位数",i + 1);
                break;
            }
        }
    }
}
