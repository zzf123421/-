package com.ljxt.chapter4;

import java.util.Scanner;

/**
 * @ClassName: Test5ShowWeekday
 * @Description: 输入1-7时，显示对应的星期的缩写，输入其他数字时提示输入错误，输入0退出
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/15 22:35
 * @Version: 1.0
 */
public class Test5ShowWeekday {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 用了一个死循环，只有输入0才能退出
        while (true) {
            System.out.print("请输入一位数字:");
            switch (input.nextInt()) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("MON");
                    break;
                case 2:
                    System.out.println("TUE");
                    break;
                case 3:
                    System.out.println("WED");
                    break;
                case 4:
                    System.out.println("THU");
                    break;
                case 5:
                    System.out.println("FRI");
                    break;
                case 6:
                    System.out.println("SAT");
                    break;
                case 7:
                    System.out.println("SUN");
                    break;
                default:
                    System.out.println("输入有误，请重新输入！");
            }
        }
    }
}
