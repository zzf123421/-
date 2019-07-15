package com.ljxt.chapter2;

import java.util.Scanner;

/**
 * @ClassName: ShowTemp
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/11 07:23
 * @Version: 1.0
 */
public class ShowTemp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入华氏温度：");
        double F = input.nextDouble();//华氏温度
        double T = 5 * (F - 32)/9;//摄氏温度
        System.out.printf("当前华氏温度为：%.1f\n",F);
        System.out.printf("当前摄氏温度为：%.1f\n",T);
    }
}
