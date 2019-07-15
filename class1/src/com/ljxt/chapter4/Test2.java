package com.ljxt.chapter4;

/**
 * @ClassName: Test2
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 20:37
 * @Version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        // 7的倍数和
        int sum = 0;
        for (int i = 1;i <= 50;i++){
            // 判断是否是7的倍数
            if (i % 7 == 0) {
                // 累加得和
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println("1到50中7的倍数之和为：" + sum);
    }
}
