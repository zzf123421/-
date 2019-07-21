package com.ljxt.chapter4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Test4FindMaxAndMin
 * @Description: 找到输入数字的最大值和最小值
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 21:01
 * @Version: 1.0
 */
public class Test4FindMaxAndMin {
    public static void main(String[] args) {
        // 用数组存放输入的数字
        int[] numArys = new int[100];
        // 数组下标
        int arysCount = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个整数（输入0结束）：");
        int inputNum = input.nextInt();
        while(inputNum != 0){
            numArys[arysCount] = inputNum;
            // 更新下标
            arysCount++;
            System.out.print("请输入一个整数（输入0结束）：");
            // 更新输入数字
            inputNum = input.nextInt();
        }
        // 用java自带的Arrays进行升序排序
//        Arrays.sort(numArys);
//        System.out.printf("最大值是：%d，最小值是：%d",numArys[99],numArys[100 - arysCount]);
        // 用自己写的冒泡排序排列数组
        bubbleSort(numArys);
        System.out.printf("最大值是：%d，最小值是：%d",numArys[0],numArys[arysCount - 1]);
    }

    /**
     * 自己写的冒泡排序,降序排列
     * @param arys 要排序的数组
     */
    public static void bubbleSort(int[] arys) {
        int temp = 0;
        for (int i = 0;i < arys.length - 1;i++) {
            for (int j = 0;j <arys.length - 1 - i;j++) {
                if(arys[j] < arys[j + 1]) {
                    temp = arys[j];
                    arys[j] = arys[j + 1];
                    arys[j + 1] = temp;
                }
            }
        }
    }
}
