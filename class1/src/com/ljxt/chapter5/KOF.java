package com.ljxt.chapter5;

import java.util.Scanner;

/**
 * @ClassName: KOF
 * @Description: 拳皇游戏
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/20 07:31
 * @Version: 1.0
 */
public class KOF {
    public static void main(String[] args) throws Exception {
        // 血量 名称 攻击力
        int playerHealth = 100;
        int comHealth = 100;
        String playerName = null;
        String comName = null;
        int attack = 0;
        System.out.println("***************************");
        System.out.println("欢迎来到拳皇游戏！");
        System.out.println("***************************\n\n");
        String message = new String("开始游戏......");
        for (int i = 0;i < message.length();i++) {
            System.out.print(message.charAt(i));
            Thread.sleep(400);
        }
        System.out.println("\n\n请选择角色：\n1，八神庵\n2，草稚京\n");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                playerName = "八神庵";
                comName = "草稚京";
                break;
            case 2:
                playerName = "草稚京";
                comName = "八神庵";
        }
        System.out.println("开始战斗！\n");
        // 循环直到有血量为负
        while (playerHealth > 0 && comHealth > 0) {
            // 随机攻击力
            attack = (int)(Math.random() * 10000) % 11 + 5;
            // 根据攻击力决定台词
            if (attack >= 14) {
                System.out.println(playerName + "向" + comName + "使出了超必杀！");
            }else if(attack >= 10) {
                System.out.println(playerName + "向" + comName + "发起了猛烈攻击！");
            }else if(attack >= 7) {
                System.out.println(playerName + "向" + comName + "发起了普通攻击");
            }else {
                System.out.println(playerName + "向" + comName + "发起了普通攻击,但被完美防御了下来");
            }
            comHealth -= attack;
            System.out.printf("%s血量减少%d！剩余血量%d\n\n",comName,attack,comHealth);
            Thread.sleep(2000);
            attack = (int)(Math.random() * 10000) % 11 + 5;
            if (attack >= 14) {
                System.out.println(comName + "向" + playerName + "使出了超必杀！");
            }else if(attack >= 10) {
                System.out.println(comName + "向" + playerName + "发起了猛烈攻击！");
            }else if(attack >= 7) {
                System.out.println(comName + "向" + playerName + "发起了普通攻击");
            }else {
                System.out.println(comName + "向" + playerName + "发起了普通攻击,但被完美防御了下来");
            }
            playerHealth -= attack;
            System.out.printf("%s血量减少%d！剩余血量%d\n\n",playerName,attack,playerHealth);
            Thread.sleep(2000);
        }
        // 判断结果
        if (comHealth <= 0 && playerHealth <= 0) {
            System.out.println("经过艰难的战斗，二者同归于尽！");
            System.exit(0);
        }
        if (comHealth <= 0 && playerHealth > 0) {
            System.out.println("经过艰难的战斗，" + playerName + "取得了胜利！");
            System.exit(0);
        }
        if (comHealth > 0 && playerHealth <= 0) {
            System.out.println("经过艰难的战斗，" + comName + "取得了胜利！");
            System.exit(0);
        }


    }
}
