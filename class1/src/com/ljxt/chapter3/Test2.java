package com.ljxt.chapter3;

import java.util.Scanner;

/**
 * @ClassName: Test2SevenMultiple
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/13 23:38
 * @Version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("请输入三个整数,用空格隔开：");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        input.close();
        int temp;//中间变量
        //确保a <= c
        if(a > c) {
            temp = a;
            a = c;
            c = temp;
        }
        //确保a <= b
        if(a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        //确保b <= c
        if(b > c) {
            temp = b;
            b = c;
            c = temp;
        }
        System.out.printf("%d,%d,%d\n",a,b,c);
    }
}
