package com.ljxt.chapter5;

import java.util.Scanner;

/**
 * @ClassName: Test2HowManyDays
 * @Description: 根据输入的日期，输出这一天是这年的第几天
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/17 13:01
 * @Version: 1.0
 */
public class Test2HowManyDays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year;
        int month;
        int day;
        // 总共的天数
        int sum = 0;
        // 存放每月天数
        int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
        while (true) {
            System.out.println("请输入当前年份(数字，例:2010)：");
            year = input.nextInt();
            // 确保年份大于0
            if (year > 0) {
                break;
            }else {
                System.out.println("请输入有效数字！");
            }
        }
        while (true) {
            System.out.println("请输入当前月份(数字，例:7)：");
            month = input.nextInt();
            // 确保月份大于0小于13
            if (month > 0 && month <= 12) {
                break;
            }else {
                System.out.println("请输入有效数字！");
            }
        }
        while (true) {
            System.out.println("请输入当前日期(数字，例:23)：");
            day = input.nextInt();
            // 确保日期大于0小于32
            if (day > 0 && day <= monthDay[month - 1]) {
                break;
            }else {
                System.out.println("请输入有效数字！");
            }
        }
        // 完整月份的天数
        for (int i = 0;i < month - 1;i++) {
            sum += monthDay[i];
        }
        // 剩余天数
        sum += day;
        // 闰年加一天
        if (month > 2){
            if (isLeapYear(year)) {
                sum++;
            }
        }
        System.out.println("今年已经过去了" + sum + "天");
    }

    /**
     * 判断是否是闰年
     * @param year 要判断的年份
     * @return 是闰年返回ture，不是返回false
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
