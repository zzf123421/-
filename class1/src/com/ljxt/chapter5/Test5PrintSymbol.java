package com.ljxt.chapter5;

/**
 * @ClassName: Test5PrintSymbol
 * @Description: 打印图形
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/17 23:13
 * @Version: 1.0
 */
public class Test5PrintSymbol {
    public static void main(String[] args) {
        // 第一个图案 *********************************
        // 第一排
        System.out.println("*********");
        // 中间几排
        for (int i = 0;i < 7;i++) {
            System.out.println("*       *");
        }
        // 最后一排
        System.out.println("*********");
        // 换种方法************************************
        // 第一排
        for (int i = 0;i < 9;i++) {
            System.out.print("*");
        }
        System.out.println();
        // 中间几排
        for (int i = 0;i < 7;i++) {
            System.out.print("*");
            for (int j = 0;j < 7;j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        // 最后一排
        for (int i = 0;i < 9;i++) {
            System.out.print("*");
        }
        System.out.println("\n\n");
        // 第二个图案 *********************************
        // 开始两行
        for (int i = 0;i < 2;i++) {
            for (int j = 0;j <= 2 - 2*i;j++) {
                System.out.print(" ");
            }
            if (i == 0) {
                for (int j = 0;j < 3;j++) {
                    System.out.print("*");
                }
            }else {
                System.out.print("*");
                for (int j = 0;j < 5;j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
        // 中间，与第一个图案相同
        for (int i = 0;i < 7;i++) {
            System.out.print("*");
            for (int j = 0;j < 7;j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        // 最后两行，与最开始两行对称
        for (int i = 0;i < 2;i++) {
            for (int j = 0;j <= 2 * i;j++) {
                System.out.print(" ");
            }
            if (i == 1) {
                for (int j = 0;j < 3;j++) {
                    System.out.print("*");
                }
            }else {
                System.out.print("*");
                for (int j = 0;j < 5;j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\n\n");
        // 第三个图案 *********************************
        // 箭头部分
        for(int i = 0;i < 3;i++) {
            for(int j = 0;j <= 2 - i;j++) {
                System.out.print(" ");
            }
            for(int j = 0;j <= 2 * i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 箭杆部分
        for(int i = 0;i < 7;i++) {
            for (int j = 0;j < 3;j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
    }
}
