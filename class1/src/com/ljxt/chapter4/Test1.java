package com.ljxt.chapter4;

/**
 * @ClassName: Test1
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 11:54
 * @Version: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        // 输出的数字
        int output = 100;
        while (output > 0) {
            System.out.print(output + "\t");
            // 换行
            if (output % 20 == 0) {
                System.out.println();
            }
            // 数字的更新
            output -= 5;
        }
    }
}
