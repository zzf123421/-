package com.ljxt.chapter3;

import java.util.Scanner;

/**
 * @ClassName: Class1
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/13 23:20
 * @Version: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = input.nextInt();
        //如果不加这句话，会直接跳过性别的输入
        String clean = input.nextLine();
        System.out.println("请输入性别：");
        String six = input.nextLine();
        //关闭Scanner
        input.close();
        if (age >= 7) {
            System.out.println("可以搬动桌子");
        }else if(age >= 5 && "男".equals(six)){//用equals判断字符串是否相等
            System.out.println("可以搬动桌子");
        }else {
            System.out.println("不能搬动桌子");
        }
    }
}
