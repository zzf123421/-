package com.ljxt.chapter5;

/**
 * @ClassName: Test6BuyChicken
 * @Description: 不同鸡的数量组合问题
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/20 00:13
 * @Version: 1.0
 */
public class Test6BuyChicken {
    public static void main(String[] args) {
        // 母鸡hen,公鸡cock,小鸡chicken
        int henPrice = 3;
        int henNum = 1;
        int cockPrice = 5;
        int cockNum = 1;
        int chickenPrice = 1;
        int chickenNum = 3;
        int totalNum = 0;
        int totalMoney = 0;
        // 母鸡最少买0个，最多买100/henPrice个，每次增加一个母鸡
        for(henNum = 0;henNum <= 100/henPrice;henNum++) {
            // 公鸡最少买0个，最多买100/cockPrice个，每次增加一个公鸡
            for (cockNum = 0;cockNum <= 100/cockPrice;cockNum++) {
                // 小鸡最少买0个，最多买300个，每次增加3个
                for (chickenNum = 0;chickenNum <= 300;chickenNum += 3) {
                    totalMoney = henNum * henPrice + cockNum * cockPrice + chickenNum / 3 * chickenPrice;
                    totalNum = henNum + chickenNum + cockNum;
                    if (totalNum == 100 && totalMoney == 100) {
                        System.out.printf("可以买%d个公鸡，%d个母鸡，%d个小鸡\n",cockNum,henNum,chickenNum);
                    }
                }
            }
        }
    }
}
