package com.ljxt.chapter3;

import java.util.Scanner;

/**
 * @ClassName: Test5
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/14 10:32
 * @Version: 1.0
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println("请输入考试成绩：");
        int score = new Scanner(System.in).nextInt();
        // 使用if ，else if 实现范围的判断
        if (score == 100) {
            System.out.println("父亲买车");
        }else if (score >= 90) {
            System.out.println("母亲买笔记本电脑");
        }else if (score >= 60) {
            System.out.println("母亲买手机");
        }
        else {
            System.out.println("没有礼物");
        }
    }
}
