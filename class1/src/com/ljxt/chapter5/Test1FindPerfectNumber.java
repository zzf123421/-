package com.ljxt.chapter5;

/**
 * @ClassName: Test1FindPerfectNumber
 * @Description: 找到1000以内的完数
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/16 23:11
 * @Version: 1.0
 */
public class Test1FindPerfectNumber {
    public static void main(String[] args) {
        // 约数和
        int sum = 0;
        // 第一个循环，1-1000的数字
        for (int i = 2;i < 1000;i++) {
            // 得出每个数的约数和
            for (int j = 1;j < i;j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            // 判断是否完数
            if (sum == i) {
                System.out.println("找到一个完数：" + i);
            }
            // 累加结果每次清零
            sum = 0;
        }
    }
}

