package com.ljxt.chapter6;

import java.util.Arrays;

/**
 * @ClassName: Practice
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/20 15:17
 * @Version: 1.0
 */
public class Practice {
    public static void main(String[] args) {
        int[] array1 = {12,23,45,22,42,32};
        int[] array2 = {32,42,45,21,11,65,35,66};
        System.out.println("直接复制前：");
        System.out.println(array1);
        System.out.println(array2);
//        array1 = array2;
//        System.out.println("直接复制后：");
//        System.out.println(array1);
//        System.out.println(array2);
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));
//        System.out.println("Arrays复制后：");
//        array1 = Arrays.copyOf(array2,array2.length);
//        System.out.println(array1);
//        System.out.println(Arrays.toString(array1));
        array1 = new int[array2.length];
        System.arraycopy(array2,0,array1,0,array2.length);
        System.out.println("底层复制后：");
        System.out.println(array1);
        System.out.println(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
