package com.ljxt.chapter6;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * @introduction
 * 拳皇97实时对战PK小游戏
 * 玩家首先投币可以进入游戏，自行选择英雄对战电脑
 * 游戏玩法：每回合随机某一方优先攻击，玩家有自己的出招表，可以自行选择，电脑则默认自己随机出招
 * 怒气系统：受到普通伤害怒气加1，受到狂暴大招伤害加2，再次基础上普通攻击和狂暴大招可以有几率触发暴击，发生暴击怒气再加1
 * 伤害系统：普通伤害范围（5-10），狂暴大招流在普通伤害的基础上加10伤害，如果触发暴击伤害再翻倍
 * @author 王森
 * @data 2019年07月17日
 * @version 1.0
 * @copyright individual
 * @remarks
 *
 * 需要改进的部分：
 * 由于自己学的还是太少，游戏存在一些bug，自己修复一部分，但是还有一部分现在实力不够，改起来会越来越麻烦
 * 由于学习进度问题，当前小游戏，只用了最基本的定义变量，if条件结构，switch选择结构，while循环结构
 * 代码量过于庞大，有很多重复的，如果学了数组和类，我相信可以减少一半的代码量
 */
public class KOF97 {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        //定义变量
        String playerName = "";        //玩家名
        String heroName = "";          //英雄名
        String computer = "八神庵";     //电脑的英雄名
        String act1 = "";              //玩家出招
        String act2 = "";              //电脑
        int hp1 = 100, hp2 = 100;      //双方初始血量为100
        int attack1, attack2;          //攻击力，在PK中随机生成
        int anger1 = 0, anger2 = 0;    //怒气值，初始值为0
        int round = 1;                 //pk回合数
        int score = 0;                 //玩家技术得分



        //首先进入投币界面
        System.out.println("\t\t----欢迎来到拳皇97PK对战小游戏----");
        File sound1 = new File("sounds/拳皇98操作示范背景音乐.wav");
        AudioClip sound_choose = Applet.newAudioClip(sound1.toURL());
        sound_choose.play();
        //创建Scanner类对象
        Scanner input = new Scanner(System.in);
        //提示用户是否投币
        System.out.println("\t\t\t是否投币：\n\t\t\t1、投币 \t2、没钱不玩");
        int choice = input.nextInt();
        if(choice == 1) {
            //游戏载入,延时2000ms
            System.out.println("\t\t\t加载游戏中······");
            Thread.sleep(2000);
            //提醒用户输入玩家名
            System.out.print("\t\t\t请输入玩家名：");
            playerName = input.next();


            //输入玩名称后进入选择英雄界面
            //播放背景音乐
            sound_choose.stop();
            sound1 = new File("sounds/拳皇98选人画面.wav");
            sound_choose = Applet.newAudioClip(sound1.toURL());
            sound_choose.play();
            if(playerName.length() > 0) {
                //提示用户选择英雄
                System.out.println("\t\t您需要对战的电脑玩家是八神庵，请选择您的英雄：");
                System.out.println("\t\t1、草稚京\t 2、大门\t 3、红丸\t4、大蛇\n\t\t由于您还不是我们的VIP客户，其他英雄暂未解锁。");
                int num = input.nextInt();
                switch (num) {
                    case 1:
                        heroName = "草稚京";
                        break;
                    case 2:
                        heroName = "大门";
                        break;
                    case 3:
                        heroName = "红丸";
                        break;
                    case 4:
                        heroName = "大蛇";
                        break;

                    default:
                        System.out.println("暂时还未开通！敬请期待···");
                        break;
                }


                //如果玩家正确选择了英雄，进入游戏准备环节
                if(num >= 1 && num <= 4) {
                    //延时1000ms
                    Thread.sleep(1000);
                    System.out.println("\t\t您成功的选择了：" + heroName + "！准备对战" + computer);
                    //播放英雄开场白背景音乐
                    sound_choose.stop();
                    sound1 = new File("sounds/拳皇98-八神VS草稚开场对话.wav");
                    sound_choose = Applet.newAudioClip(sound1.toURL());
                    sound_choose.play();
                    System.out.println("\n\t\t\t" + heroName + "\t VS\t" + computer);
                    //延时6000ms，开场白对话背景音乐播放完毕
                    Thread.sleep(6000);

                    //开始对战
                    //播放开始音乐
                    sound_choose.stop();
                    sound1 = new File("sounds/拳皇98格斗开始.wav");
                    sound_choose = Applet.newAudioClip(sound1.toURL());
                    sound_choose.play();
                    //延时4000ms，开始对战音乐播放完毕
                    Thread.sleep(4000);


                    //利用while循环结构，当双方血量大于0，一直pk下去
                    while(hp1 > 0 && hp2 > 0) {
                        //每局开头简介   第几回合   英雄  血量    怒气
                        Thread.sleep(2000);
                        System.out.println("\n\t************************" + "Round" + round + "************************");
                        System.out.print("\t" + heroName + "  hp:" + hp1 + "   anger：" + anger1);
                        System.out.print("\t\t" + computer + "  hp:" + hp2 + "   anger：" + anger2);

                        //每局随机生成攻击力，普通攻击力5-10
                        attack1 =(int) (Math.random() * 1000 % 6 + 5);
                        attack2 =(int) (Math.random() * 1000 % 6 + 5);

                        //表示攻击状态，1为玩家先进攻，2为电脑先进攻
                        int condition;
                        //如果随机数为偶数玩家先进攻，随机数为奇数电脑先进攻
                        if((int)(Math.random()*10000) % 2 == 0) {
                            condition = 1;
                        }else {
                            condition = 2;
                        }

                        //怒气值满5 ，进入狂暴状态，可以释放大招，攻击力增加20

                        //情况1：两者怒气都不满5
                        if(anger1 < 5 && anger2 < 5) {
                            if(condition == 1) {
                                System.out.println("\n\n\t由你出招：\n\t1、轻拳\t2、轻脚\t3、膝撞\t4、背摔");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "轻拳";
                                        break;
                                    case 2:
                                        act1 = "轻脚";
                                        break;
                                    case 3:
                                        act1 = "膝撞";
                                        break;
                                    case 4:
                                        act1 = "背摔";
                                        break;
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\t" + heroName + "先发制人，打出一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加2,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "轻拳";
                                        break;
                                    case 2:
                                        act2 = "轻脚";
                                        break;
                                    case 3:
                                        act2 = "膝撞";
                                        break;
                                    case 4:
                                        act2 = "背摔";
                                        break;
                                }

                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + computer + "迅速反击，打出一记" + act2 + "!");
                            }else {
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "轻拳";
                                        break;
                                    case 2:
                                        act2 = "轻脚";
                                        break;
                                    case 3:
                                        act2 = "膝撞";
                                        break;
                                    case 4:
                                        act2 = "背摔";
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\n\t" + computer + "先发制人，打出一记" + act2 + "!");
                                System.out.println("\n\t由你出招表：\n\t1、轻拳\t2、轻脚\t3、膝撞\t4、背摔");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "轻拳";
                                        break;
                                    case 2:
                                        act1 = "轻脚";
                                        break;
                                    case 3:
                                        act1 = "膝撞";
                                        break;
                                    case 4:
                                        act1 = "背摔";
                                        break;
                                    //输入其他数字，停止攻击，轮空一回合。
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + heroName + "迅速反击，打出一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                            }
                            //普通攻击得分加200
                            score += 200;
                            //受到普通攻击，怒气值自增1
                            anger1++;
                            anger2++;

                            //情况2：玩家怒气值满5，电脑怒气值小于5
                        }else if(anger1 >= 5 && anger2 < 5) {
                            //提示玩家已进入狂暴状态
                            System.out.println("\n\n\t" + heroName + "已进入狂暴状态，可以随心所欲释放大招！");
                            //狂暴状态攻击力加10
                            attack1 += 10;
                            if(condition == 1) {
                                System.out.println("\n\n\t由你出招：\n\t1、秘奥义 里百八式·大蛇薙\t2、禁千二百十一式·八稚女\t3、百式·鬼燃烧\t4、外式·轰斧阴·死神");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act1 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act1 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act1 = "外式·轰斧阴·死神";
                                        break;
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\t" + heroName + "先发制人，打出狂暴一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "轻拳";
                                        break;
                                    case 2:
                                        act2 = "轻脚";
                                        break;
                                    case 3:
                                        act2 = "膝撞";
                                        break;
                                    case 4:
                                        act2 = "背摔";
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + computer + "迅速反击，打出一记" + act2 + "!");
                            }else {
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "轻拳";
                                        break;
                                    case 2:
                                        act2 = "轻脚";
                                        break;
                                    case 3:
                                        act2 = "膝撞";
                                        break;
                                    case 4:
                                        act2 = "背摔";
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\n\t" + computer + "先发制人，打出一记" + act2 + "!");
                                System.out.println("\n\t由你出招表：\n\t1、秘奥义 里百八式·大蛇薙\t2、禁千二百十一式·八稚女\t3、百式·鬼燃烧\t4、外式·轰斧阴·死神");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act1 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act1 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act1 = "外式·轰斧阴·死神";
                                        break;
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + heroName + "迅速反击，打出狂暴一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                            }

                            //狂暴大招攻击得分加800
                            score += 800;
                            //受到普通攻击，怒气值自增1，受到大招伤害怒气值增加2
                            anger1++;
                            anger2 += 2;

                            //情况3：电脑怒气值满5，玩家怒气值小于5
                        }else if(anger1 < 5 && anger2 >= 5) {
                            //提示电脑进入狂暴状态
                            System.out.println("\n\n\t" + "小心！" + computer + "已经狂暴状态，可以随心所欲的释放大招！");
                            //狂暴状态攻击力加10
                            attack2 += 10;
                            if(condition == 1) {
                                System.out.println("\n\n\t由你出招：\n\t1、轻拳\t2、轻脚\t3、膝撞\t4、背摔");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "轻拳";
                                        break;
                                    case 2:
                                        act1 = "轻脚";
                                        break;
                                    case 3:
                                        act1 = "膝撞";
                                        break;
                                    case 4:
                                        act1 = "背摔";
                                        break;
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\t" + heroName + "先发制人，打出一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act2 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act2 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act2 = "外式·轰斧阴·死神";
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + computer + "迅速反击，打出狂暴一记" + act2 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + computer + "触发了暴击，攻击力翻倍！");
                                    attack2 *= 2;
                                    anger1++;
                                }
                            }else {
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act2 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act2 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act2 = "外式·轰斧阴·死神";
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\n\t" + computer + "先发制人，打出狂暴一记" + act2 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + computer + "触发了暴击，攻击力翻倍！");
                                    attack2 *= 2;
                                    anger1++;
                                }
                                System.out.println("\n\t由你出招表：\n\t1、轻拳\t2、轻脚\t3、膝撞\t4、背摔");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "轻拳";
                                        break;
                                    case 2:
                                        act1 = "轻脚";
                                        break;
                                    case 3:
                                        act1 = "膝撞";
                                        break;
                                    case 4:
                                        act1 = "背摔";
                                        break;
                                    //输入其他数字，停止攻击，轮空一回合。
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-必杀技集合.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + heroName + "迅速反击，打出一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                            }

                            //普通攻击得分加200
                            score += 200;
                            //受到普通攻击，怒气值自增1
                            anger1 += 2;
                            anger2++;

                            //情况4：双方怒气值均满5，都进入狂暴状态
                        }else {
                            //提示双方都已经进入狂暴状态
                            System.out.println("\n\n\t" + heroName + "已经进入狂暴状态，可以随心所欲的释放大招！");
                            System.out.println("\t" + "小心！" + computer + "已经进入狂暴状态，可以随心所欲的释放大招！");
                            //狂暴状态攻击力加10
                            attack1 += 10;
                            attack2 += 10;
                            if(condition == 1) {
                                System.out.println("\n\n\t由你出招：\n\t1、秘奥义 里百八式·大蛇薙\t2、禁千二百十一式·八稚女\t3、百式·鬼燃烧\t4、外式·轰斧阴·死神");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act1 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act1 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act1 = "外式·轰斧阴·死神";
                                        break;
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\t" + heroName + "先发制人，打出狂暴一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act2 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act2 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act2 = "外式·轰斧阴·死神";
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + computer + "迅速反击，打出狂暴一记" + act2 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + computer + "触发了暴击，攻击力翻倍！");
                                    attack2 *= 2;
                                    anger1++;
                                }
                            }else {
                                switch ((int)(Math.random()*10000) % 4 + 1) {
                                    case 1:
                                        act2 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act2 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act2 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act2 = "外式·轰斧阴·死神";
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\n\n\t" + computer + "先发制人，打出狂暴一记" + act2 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + computer + "触发了暴击，攻击力翻倍！");
                                    attack2 *= 2;
                                    anger1++;
                                }
                                System.out.println("\n\t由你出招表：\n\t1、秘奥义 里百八式·大蛇薙\t2、禁千二百十一式·八稚女\t3、百式·鬼燃烧\t4、外式·轰斧阴·死神");
                                int choice2 = input.nextInt();
                                switch (choice2) {
                                    case 1:
                                        act1 = "秘奥义 里百八式·大蛇薙";
                                        break;
                                    case 2:
                                        act1 = "禁千二百十一式·八稚女";
                                        break;
                                    case 3:
                                        act1 = "百式·鬼燃烧";
                                        break;
                                    case 4:
                                        act1 = "外式·轰斧阴·死神";
                                        break;
                                    //输入其他数字，停止攻击，轮空一回合。
                                    default:
                                        act1 = "自我罚站";
                                        attack1 = 0;
                                        break;
                                }
                                sound_choose.stop();
                                sound1 = new File("sounds/拳皇98草雉京-超比杀.wav");
                                sound_choose = Applet.newAudioClip(sound1.toURL());
                                sound_choose.play();
                                Thread.sleep(2000);
                                System.out.println("\t" + heroName + "迅速反击，打出狂暴一记" + act1 + "!");
                                //暴击系统    30%的几率除非暴击，攻击翻倍，暴击伤害使对方怒气值加1,暴击加分500
                                if(((int)(Math.random()*10000) % 10 + 1) <= 3) {
                                    System.out.println("\t" + heroName + "触发了暴击，攻击力翻倍！");
                                    attack1 *= 2;
                                    anger2++;
                                    score += 500;
                                }
                            }

                            //狂暴大招得分加200
                            score += 800;
                            //受到大招攻击，怒气值增加2
                            anger1 += 2;
                            anger2 += 2;
                        }


                        //扣血系统    生命值小于0时，重置为0。停止攻击，并宣布比赛结果
                        //如果是玩家先攻击，电脑先扣血，如果生命值小于等于0，停止攻击，生命值置为0
                        if(condition == 1) {
                            hp2 -= attack1;
                            if(hp2 <= 0) {
                                attack2 = 0;
                                hp2 = 0;
                            }
                            hp1 -= attack2;
                            //如果电脑先攻击，玩家先扣血，如果生命值小于等于0，停止攻击，生命值置为0
                        }else {
                            hp1 -= attack2;
                            if(hp1 <= 0) {
                                attack1 = 0;
                                hp1 = 0;
                            }
                            hp2 -= attack1;
                        }

                        //打印每局战况
                        Thread.sleep(500);
                        System.out.println("\n\t" + heroName + "本局受到" + attack2 + "点伤害，剩余生命值：" + hp1 + "\n");
                        System.out.println("\t" + computer + "本局受到" + attack1 + "点伤害，剩余生命值：" + hp2 + "\n");

                        //如果某一方生命值为0，播放背景音乐，并宣布结果
                        if(hp1 <= 0 || hp2 <= 0) {
                            Thread.sleep(500);
                            sound_choose.stop();
                            sound1 = new File("sounds/5731.wav");
                            sound_choose = Applet.newAudioClip(sound1.toURL());
                            sound_choose.play();
                        }
                        if(hp1 <= 0) {
                            Thread.sleep(1000);
                            System.out.println("\n\n\t\tDEFEAT!水平有待提升！需要勤加练习！");
                        }else if(hp2 <= 0){
                            Thread.sleep(1000);
                            System.out.println("\n\t\tVICTORY!你很强!电脑已经无法阻止你了！");
                        }
                        //每次循环后，回合数自增1
                        ++round;
                    }
                }
            }
        }else{
            System.out.println("骚年，赶紧去搬砖吧！");
        }
        input.close();
        //延时1000ms，退出游戏，并显示得分
        Thread.sleep(1000);
        System.out.println("\n\t\t游戏结束！" + "玩家：" + playerName + "获得的技术总分是：" + score + "分！");

    }

}