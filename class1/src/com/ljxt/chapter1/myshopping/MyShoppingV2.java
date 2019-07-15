package com.ljxt.chapter1.myshopping;

import java.util.Scanner;

/**
 * @ClassName: MyShoppingV2
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/10 19:15
 * @Version: 1.0
 */
public class MyShoppingV2 {
    public static void main(String[] args) {
        System.out.println("\t\t\t欢迎使用我型我素购物管理系统1.0版\n");
        System.out.println("\t\t\t\t1，登 录 系 统\n");
        System.out.println("\t\t\t\t2，退 出\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.print("请选择，输入数字：");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                menu();
                break;
            case 2:
                System.exit(0);
        }
    }

    private static void menu() {
        System.out.println("\n\n\t\t\t\t欢迎使用我型我素购物管理系统\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("\t\t\t\t1，客 户 信 息 管 理\n");
        System.out.println("\t\t\t\t2，购 物 结 算\n");
        System.out.println("\t\t\t\t3，真 情 回 馈\n");
        System.out.println("\t\t\t\t4，注 销\n");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.print("请选择，输入数字：");
    }
}
