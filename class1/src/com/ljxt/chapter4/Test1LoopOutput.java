package com.ljxt.chapter4;

/**
 * @ClassName: Test1LoopOutput
 * @Description: 使用循环输出：100，95，90，85...
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 11:54
 * @Version: 1.0
 */
public class Test1LoopOutput {
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
