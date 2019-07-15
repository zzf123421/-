package com.ljxt.chapter3;

import java.util.Scanner;

/**
 * @ClassName: ChangeMoney
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/13 15:24
 * @Version: 1.0
 */
public class ChangeMoney {
    public static void main(String[] args) {
        System.out.print("请输入总钱数：");
        double money = new Scanner(System.in).nextDouble();
        int moneyChange = (int)(money * 100);
        // 有多少100元纸币
        int hundred = moneyChange / 10000;
        // 有多少50元纸币
        int fifty = moneyChange % 10000 / 5000;
        // 有多少10元纸币
        int ten = moneyChange % 5000 /1000;
        // 有多少5元纸币
        int five = moneyChange % 1000 / 500;
        // 有多少1元纸币
        int one = moneyChange % 500 / 100;
        // 有多少5毛纸币
        int fiveMao = moneyChange % 100 / 50;
        // 有多少1毛纸币
        int oneMao = moneyChange % 50 / 10;
        // 有多少5分纸币
        int fiveFen = moneyChange % 10 / 5;
        // 有多少1分纸币
        int oneFen = moneyChange % 5;
        // 小于1分的都忽略不计
        System.out.printf("有%d张百元纸币\n",hundred);
        System.out.printf("有%d张五十元纸币\n",fifty);
        System.out.printf("有%d张十元纸币\n",ten);
        System.out.printf("有%d张五元纸币\n",five);
        System.out.printf("有%d张一元纸币\n",one);
        System.out.printf("有%d张五毛纸币\n",fiveMao);
        System.out.printf("有%d张一毛纸币\n",oneMao);
        System.out.printf("有%d张五分纸币\n",fiveFen);
        System.out.printf("有%d张一分纸币\n",oneFen);
    }
}
