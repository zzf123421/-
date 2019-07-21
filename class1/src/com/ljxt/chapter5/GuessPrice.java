package com.ljxt.chapter5;

import java.util.Scanner;

/**
 * @ClassName: GuessPrice
 * @Description: 徐老师猜价格作业
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/20 07:18
 * @Version: 1.0
 */
public class GuessPrice {
    public static void main(String[] args) {
        // 随机生成一个1000的倍数作为价格
        int price = ((int)(Math.random() * 10000) % 10 + 1) * 1000;
        // 猜测次数
        int count = 0;
        // 猜测的价格
        int guess = 0;
        Scanner input = new Scanner(System.in);
        for (count = 0;count < 5;count++) {
            System.out.print("请输入猜测的价格：");
            guess = input.nextInt();
            if (guess > price) {
                System.out.println("猜大了");
            }
            if (guess < price) {
                System.out.println("猜小了");
            }
            if (guess == price) {
                break;
            }
        }
        // 结果
        switch (count) {
            case 0:
                System.out.println("恭喜获得iPhone8S Plus Plus 土豪金一部！");
                break;
            case 1: case 2:
                System.out.println("恭喜获得华为荣耀手环ZERO！");
                break;
            case 3: case 4:
                System.out.println("恭喜获得小米蓝牙耳机青春版！");
                break;
            default:
                System.out.println("5次机会已用完，请再接再厉！");
        }
    }
}
