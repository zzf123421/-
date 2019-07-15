package com.ljxt.chapter3;

import java.util.Scanner;

/**
 * @ClassName: Test6
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 10:43
 * @Version: 1.0
 */
public class Test6 {
    static Scanner input = new Scanner(System.in);
    static int choose;
    public static void main(String[] args) {
        System.out.println("欢迎来到自助投胎系统！");
        System.out.println("1：我要投胎");
        System.out.println("2：退出");
        System.out.print("请选择：");
        // 希望用户输入数字1或2
        choose = input.nextInt();
        switch (choose) {
            case 1:
                chooseSix();
                break;
            // 输入2或者其他数字都是退出系统，所以只用一个default
            default:
                System.exit(0);
        }
    }

    /**
     * 性别选择界面
     */
    private static void chooseSix() {
        System.out.println("\n\n选择性别");
        System.out.println("1：男（免费）");
        System.out.println("2：女（50币）");
        System.out.print("请选择：");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                chooseDiffcult();
                break;
            case 2:
                recharge();
                break;
            default:
                System.out.println("请正确输入！");
                chooseSix();
        }
    }

    /**
     * 充值界面
     */
    private static void recharge() {
        System.out.println("\n\n您的余额为零");
        System.out.println("1：老子要充值");
        System.out.println("2：没钱不充");
        System.out.print("请选择：");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("对不起，您的资金不足，无法充值！");
                recharge();
                break;
            case 2:
                chooseSix();
                break;
            default:
                System.out.println("请正确输入！");
                recharge();
        }
    }

    /**
     * 难度选择界面
     */
    private static void chooseDiffcult() {
        System.out.println("\n\n选择生存难度");
        System.out.println("1：简单（1w币）");
        System.out.println("2：一般（5000币）");
        System.out.println("3：困难（1000币）");
        System.out.println("4：深渊（免费）");
        System.out.print("请选择：");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("你的余额不足！请重新选择");
                chooseDiffcult();
                break;
            case 2:
                System.out.println("你的余额不足！请重新选择");
                chooseDiffcult();
                break;
            case 3:
                System.out.println("你的余额不足！请重新选择");
                chooseDiffcult();
                break;
            case 4:
                chooseBirth();
                break;
            default:
                System.out.println("请正确输入！");
                chooseDiffcult();
        }
    }

    /**
     * 出身选择界面
     */
    private static void chooseBirth() {
        System.out.println("\n\n选择出身");
        System.out.println("1：我爸是李刚套餐（10w币）");
        System.out.println("2：富二代（5w币）");
        System.out.println("3：官二代（5w币）");
        System.out.println("4：军二代（5w币）");
        System.out.println("5：穷逼（免费）");
        System.out.print("请选择：");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("你的余额不足！请重新选择");
                chooseBirth();
                break;
            case 2:
                System.out.println("你的余额不足！请重新选择");
                chooseBirth();
                break;
            case 3:
                System.out.println("你的余额不足！请重新选择");
                chooseBirth();
                break;
            case 4:
                System.out.println("你的余额不足！请重新选择");
                chooseBirth();
                break;
            case 5:
                chooseSkill();
                break;
            default:
                System.out.println("请正确输入！");
                chooseBirth();
        }
    }

    /**
     * 技能选择界面
     */
    private static void chooseSkill() {
        System.out.println("\n\n选择技能");
        System.out.println("1：赚钱（1w币）");
        System.out.println("2：把妹（1w币）");
        System.out.println("3：文艺（1w币）");
        System.out.println("4：技工（1w币）");
        System.out.println("5：泡面（500币）");
        System.out.println("6：啥都不会（免费）");
        System.out.print("请选择：");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("你的余额不足！请重新选择");
                chooseSkill();
                break;
            case 2:
                System.out.println("你的余额不足！请重新选择");
                chooseSkill();
                break;
            case 3:
                System.out.println("你的余额不足！请重新选择");
                chooseSkill();
                break;
            case 4:
                System.out.println("你的余额不足！请重新选择");
                chooseSkill();
                break;
            case 5:
                System.out.println("你的余额不足！请重新选择");
                chooseSkill();
                break;
            case 6:
                chooseFace();
                break;
            default:
                System.out.println("请正确输入！");
                chooseSkill();
        }
    }

    /**
     * 长相选择界面
     */
    private static void chooseFace() {
        System.out.println("\n\n选择长相");
        System.out.println("1：帅哥套餐1（1w币）");
        System.out.println("2：帅哥套餐2（1w币）");
        System.out.println("3：帅哥套餐3（1w币）");
        System.out.println("4：随机（免费）");
        System.out.print("请选择：");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("你的余额不足！请重新选择");
                chooseFace();
                break;
            case 2:
                System.out.println("你的余额不足！请重新选择");
                chooseFace();
                break;
            case 3:
                System.out.println("你的余额不足！请重新选择");
                chooseFace();
                break;
            case 4:
                getEvaluate();
                break;
            default:
                System.out.println("请正确输入！");
                chooseFace();
        }
    }

    /**
     * 评价界面
     */
    private static void getEvaluate() {
        System.out.println("\n\n是否投诉");
        System.out.println("1：投诉");
        System.out.println("2：不投诉");
        System.out.print("请选择：");
        choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("\n\n感谢您的评价，系统将免费赠送您一套疤痕套餐！");
                break;
            default:
                System.out.println("\n\n感谢您的使用，欢迎下次再来！");
        }
    }
}
