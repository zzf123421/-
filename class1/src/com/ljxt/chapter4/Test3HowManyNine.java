package com.ljxt.chapter4;

import java.util.Scanner;

/**
 * @ClassName: Test3HowManyNine
 * @Description: 判断一个数能被多少个9整除
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 20:45
 * @Version: 1.0
 */
public class Test3HowManyNine {
    public static void main(String[] args) {
        System.out.print("请输入要判断的数字：");
        int input = new Scanner(System.in).nextInt();
        // 保存原始数字
        int num = input;
        // 计数，能被9整除的次数
        int count = 0;
        // 当数字不能被9整除，退出循环
        while (num / 9 != 0) {
            count++;
            // 更新数字
            num /= 9;
        }
        System.out.println(input + "能被" + count + "个9整除");
    }
}
