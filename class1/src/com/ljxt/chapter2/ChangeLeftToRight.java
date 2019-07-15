package com.ljxt.chapter2;

/**
 * @ClassName: ChangeLeftToRight
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/11 07:15
 * @Version: 1.0
 */
public class ChangeLeftToRight {
    public static void main(String[] args) {
        int left = 10;//左手的牌
        int right = 8;//右手的牌
        System.out.println("输出互换前手中的纸牌：");
        System.out.printf("左手中的纸牌：%d\n",left);
        System.out.printf("右手中的纸牌：%d\n",right);
        int temp;//临时交换所需变量
        temp = left;
        left = right;
        right = temp;
        System.out.println("\n输出互换后手中的纸牌：");
        System.out.printf("左手中的纸牌：%d\n",left);
        System.out.printf("右手中的纸牌：%d\n",right);
    }
}
