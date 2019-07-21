package com.ljxt.chapter6.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: ShowSystem
 * @Description: 老九人气主播管理系统
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/21 14:33
 * @Version: 1.0
 */
public class ShowSystem {
    // 存储空间为十位主播，初始有五位主播，anchor 主播
    // 主播名字
    static String[] anchorName = {"主播A","主播B","主播C","主播D","主播E","","","","",""};
    // 主播特长
    static String[] anchorSpeciality = {"唱歌","跳舞","玩游戏","吃东西","写作业","","","","",""};
    // 主播介绍
    static String[] anchorIntroduce = {"绝世歌姬","舞姿动人","职业玩家","美食品鉴","我爱学习","","","","",""};
    // 主播粉丝数
    static int[] fansNums = {12342,45523,2223,4399,10086,0,0,0,0,0};
    // 主播数量
    static int anchorNum = 5;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        showMenu();
    }

    /**
     * 显示主功能菜单
     * 思路：用死循环及getInput()确保用户的输入
     */
    private static void showMenu() throws InterruptedException {
        System.out.println("功能菜单：");
        System.out.println("1，主播列表查看");
        System.out.println("2，粉丝数量排序");
        System.out.println("3，新增主播信息");
        System.out.println("4，主播上线圈粉");
        System.out.println("5，主播拉黑");
        System.out.println("6，退出程序");
        System.out.print("请选择功能：");
        while (true) {
            switch (getInput()) {
                case 1:
                    showList();
                case 2:
                    fansSort();
                case 3:
                    addAnchor();
                case 4:
                    addFans();
                case 5:
                    deleteAnchor();
                case 6:
                    exitSystem();
                default:
                    System.out.println("请输入有效数字！");
                    break;
            }
        }
    }

    /**
     * 退出系统
     * 思路：简单的输入判断
     */
    private static void exitSystem() throws InterruptedException{
        input.nextLine();
        System.out.println("请确认是否退出：");
        System.out.println("1，确定退出");
        System.out.println("2，不退出");
        while (true) {
            switch (getInput()) {
                case 1:
                    System.exit(0);
                case 2:
                    showMenu();
                default:
                    System.out.println("请输入有效数字！");
                    break;
            }
        }
    }

    /**
     * 粉丝数量排序
     * 思路：先复制一个粉丝数量的数组，再采用冒泡排序对复制的数组进行排序，
     * 再用一个新数组存储排序后对应排序前的数组下标，再以此为顺序输出数组
     */
    private static void fansSort() throws InterruptedException{
        int[] newFansNums = Arrays.copyOf(fansNums,anchorNum);
        // 冒泡排序
        for (int i = 0;i < anchorNum - 1;i++) {
            for (int j = 0;j < anchorNum - i - 1;j++) {
                if (newFansNums[j] < newFansNums[j + 1]) {
                    int temp = newFansNums[j];
                    newFansNums[j] = newFansNums[j + 1];
                    newFansNums[j + 1] = temp;
                }
            }
        }
        int[] newSort = new int[anchorNum];
        for (int i = 0; i < newFansNums.length; i++) {
            for (int j = 0; j < newFansNums.length; j++) {
                if (newFansNums[i] == fansNums[j]){
                    newSort[i] = j;
                    continue;
                }
            }
        }
        System.out.println("粉丝数量排序");
        System.out.println("-----------------------------------------");
        System.out.printf("|编号\t主播名\t特长  \t粉丝数\t介绍\t\t|\n");
        for (int i = 0;i < anchorNum;i++) {
            System.out.println("-----------------------------------------");
            System.out.printf("|%2d\t\t%s\t%s  \t%d\t%s\t|\n",
                    newSort[i],anchorName[newSort[i]],anchorSpeciality[newSort[i]],
                    fansNums[newSort[i]],anchorIntroduce[newSort[i]]
            );
        }
        System.out.println("-----------------------------------------");
        System.out.println("按任意键返回上一页");
        while (input.hasNext()) {
            input.next();
            showMenu();
        }
    }

    /**
     * 主播上线圈粉
     * 思路：输入名称，进行匹配，如果有，就记下下标，然后更改粉丝数
     */
    private static void addFans() throws InterruptedException {
        input.nextLine();
        System.out.println("请输入将要直播的主播：");
        String onlineAnchor = input.nextLine();
        int chooseAnchor = -1;
        for (int i = 0; i < anchorNum; i++) {
            if (anchorName[i].equals(onlineAnchor)) {
                chooseAnchor = i;
            }
        }
        if (chooseAnchor == -1) {
            System.out.println("该主播未找到，请确认后再试！");
            showMenu();
        }
        System.out.printf("主播：%s\t粉丝数：%d\n", anchorName[chooseAnchor], fansNums[chooseAnchor]);
        String show = "直播中----------";
        for (int i = 0;i < show.length();i++) {
            System.out.print(show.charAt(i));
            Thread.sleep(400);
        }
        System.out.print("\t直播结束！请输入现在粉丝数量：");
        fansNums[chooseAnchor] = getInput();
        System.out.println("粉丝数已更新！返回主菜单");
        System.out.printf("主播：%s\t粉丝数：%d\n", anchorName[chooseAnchor], fansNums[chooseAnchor]);
        showMenu();
    }

    /**
     * 新增主播信息
     * 思路：先检查数组空间是否充足，再进行输入
     */
    private static void addAnchor() throws InterruptedException{
        if (anchorNum >= 10) {
            System.out.println("系统空间不足，无法添加主播，请拉黑一些主播后再试！");
            showMenu();
        }
        System.out.println("新增主播信息");
        input.nextLine();
        System.out.print("请输入新增主播的名称：");
        anchorName[anchorNum] = input.nextLine();
        System.out.print("请输入新增主播的特长：");
        anchorSpeciality[anchorNum] = input.nextLine();
        System.out.print("请输入新增主播的粉丝数：");
        fansNums[anchorNum] = getInput();
        input.nextLine();
        System.out.print("请输入新增主播的介绍：");
        anchorIntroduce[anchorNum] = input.nextLine();
        System.out.printf("%2d\t%s\t%s\t%d\t%s\n",
                anchorNum - 1,anchorName[anchorNum],anchorSpeciality[anchorNum],
                fansNums[anchorNum],anchorIntroduce[anchorNum]
        );
        System.out.println("请确认是否增加此主播：");
        System.out.println("1，确认（将存储此主播）");
        System.out.println("2，删除（将删除此主播）");
        while (true) {
            switch (getInput()) {
                case 1:
                    anchorNum++;
                    showMenu();
                case 2:
                    showMenu();
                default:
                    System.out.println("请输入有效数字！");
                    break;
            }
        }
    }

    /**
     * 主播拉黑
     * 思路：先找到要拉黑的主播的下标，然后后面的覆盖前面的，主播数量减一，其他数组同样操作
     */
    private static void deleteAnchor() throws InterruptedException{
        input.nextLine();
        System.out.println("请输入将要拉黑的主播：");
        String onlineAnchor = input.nextLine();
        int chooseAnchor = -1;
        for (int i = 0; i < anchorNum; i++) {
            if (anchorName[i].equals(onlineAnchor)) {
                chooseAnchor = i;
            }
        }
        if (chooseAnchor == -1) {
            System.out.println("该主播未找到，请确认后再试！");
            showMenu();
        }
        for (int i = chooseAnchor;i < anchorNum - 1;i++) {
            anchorName[i] = anchorName[i + 1];
            anchorSpeciality[i] = anchorSpeciality[i + 1];
            anchorIntroduce[i] = anchorIntroduce[i + 1];
            fansNums[i] = fansNums[i + 1];
        }
        anchorNum--;
        System.out.println("已成功拉黑，返回主菜单");
        showMenu();
    }

    /**
     * 主播列表查看
     * 思路：用printf以及\t控制格式，返回上一页直接调用方法
     */
    private static void showList() throws InterruptedException {
        System.out.println("主播列表查看");
        System.out.println("  请选择想要观看的主播");
        System.out.println("-----------------------------------------");
        System.out.printf("|编号\t主播名\t特长  \t粉丝数\t介绍\t\t|\n");
        for (int i = 0;i < anchorNum;i++) {
            System.out.println("-----------------------------------------");
            System.out.printf("|%2d\t\t%s\t%s  \t%d\t%s\t|\n",
                    i,anchorName[i],anchorSpeciality[i],fansNums[i],anchorIntroduce[i]
            );
        }
        System.out.println("-----------------------------------------");
        System.out.println("按任意键返回上一页");
        while (input.hasNext()) {
            input.next();
            showMenu();
        }
    }

    /**
     * 用来获取用户输入信息
     * @return 返回用户的输入
     */
    private static int getInput(){
        while (!input.hasNextInt()) {
            System.out.println("请输入有效数字！");
            input.next();
        }
        return input.nextInt();
    }
}
