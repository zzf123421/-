package com.ljxt.chapter2;

/**
 * @ClassName: ShopList
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/11 07:02
 * @Version: 1.0
 */
public class ShopList {
    public static void main(String[] args) {
        int Tshirt = 245,count1 = 2;//T恤单价，数量
        int shoes = 570,count2 = 1;//鞋单价，数量
        int pat = 320,count3 = 1;//网球拍单价，数量
        double total = Tshirt * count1 + shoes * count2 + pat * count3;
        System.out.printf("消费总金额：%.2f\n",total);
        System.out.printf("实际总金额：%.2f\n",total * 0.8);
    }
}