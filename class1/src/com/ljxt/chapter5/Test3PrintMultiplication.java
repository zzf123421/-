package com.ljxt.chapter5;

/**
 * @ClassName: Test3PrintMultiplication
 * @Description: 打印乘法表
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/17 23:04
 * @Version: 1.0
 */
public class Test3PrintMultiplication {
    public static void main(String[] args) {
        // i，j分别为两个乘数
        for (int i = 1;i < 10;i++) {
            for (int j = 1;j <= i;j++) {
                System.out.printf("%d * %d = %d\t",i,j,i*j);
            }
            // 每行换行
            System.out.println();
        }
    }
}
