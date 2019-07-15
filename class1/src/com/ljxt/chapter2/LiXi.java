package com.ljxt.chapter2;

import java.util.Scanner;

/**
 * @ClassName: LiXi
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/11 07:32
 * @Version: 1.0
 */
public class LiXi {
    public static void main(String[] args) {
        final double ONE_YEAR_RATE = 0.0225;
        final double TWO_YEAR_RATE = 0.027;
        final double THR_YEAR_RATE = 0.0324;
        final double FIVE_YEAR_RATE = 0.036;
        System.out.println("请输入本金：");
        double benjin = new Scanner(System.in).nextDouble();//输入本金
        //两年，三年，五年的本息和
        double twoYearTotal = benjin;
        double threeYearTotal = benjin;
        double fiveYearTotal = benjin;
        //计算两年的本息和
        for (int i = 0;i < 2;i++) {
            twoYearTotal = twoYearTotal * (1 + TWO_YEAR_RATE);
        }
        //计算三年的本息和
        for (int i = 0;i < 3;i++) {
            threeYearTotal *= (1 + THR_YEAR_RATE);
        }
        //计算五年的本息和
        for (int i = 0;i < 5;i++) {
            fiveYearTotal *= (1 + FIVE_YEAR_RATE);
        }
        System.out.printf("存一年本息和为：%.2f\n",benjin * (1 + ONE_YEAR_RATE));
        System.out.printf("存两年本息和为：%.2f\n",twoYearTotal);
        System.out.printf("存三年本息和为：%.2f\n",threeYearTotal);
        System.out.printf("存五年本息和为：%.2f\n",fiveYearTotal);
    }
}
