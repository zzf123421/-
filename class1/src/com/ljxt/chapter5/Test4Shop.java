package com.ljxt.chapter5;

/**
 * @ClassName: Test4Shop
 * @Description: 计算顾客比例
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/17 23:12
 * @Version: 1.0
 */
public class Test4Shop {
    public static void main(String[] args) {
        // 存放年龄以及计数
        int age = 0;
        int over30Count = 0;
        // 随机生成10位顾客的年龄
        for (int i = 0;i < 10;i++) {
            age = (int)(Math.random() * 10000) % 21 + 20;
            if(age >= 30) {
                over30Count++;
            }
        }
        System.out.printf("大于30岁的顾客所占比例为%.0f%%,\n小于30岁的顾客所占比例为%.0f%%",
                over30Count / 10.0 * 100,(10 - over30Count) / 10.0 * 100);
    }
}
