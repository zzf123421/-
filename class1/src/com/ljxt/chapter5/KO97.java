package com.ljxt.chapter5;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName: KO97
 * @Description: TODO
 * @Author: 飞猫
 * @Group: 初心
 * @Date: 2019/7/20 11:29
 * @Version: 1.0
 */
public class KO97 {

    public static void main(String[] agrs) throws MalformedURLException, InterruptedException{
        Scanner input = new Scanner(System.in);
        File sound = new File("sounds/拳皇98八神关背景音乐.wav");
        AudioClip sound_choose = Applet.newAudioClip(sound.toURL());
        sound_choose.play();
        //让程序方便播放音乐

        int hp1 = 100;
        int hp2 = 100;
        Random ran = new Random();

        //主循环逻辑
        while(hp1 > 0 && hp2 > 0){
            //生成随机的战斗力
            int attack1 = ran.nextInt(11) + 5;
            hp2 -= attack1;
            if(hp2 < 0) hp2 = 0;
            System.out.println("玩家1攻击玩家2,玩家2的剩余血量为" + hp2);
            Thread.sleep(300);
            if(hp2 <= 0){
                System.out.println("玩家2死亡！！！");
                break;
            }
            //生成随机的战斗力
            int attack2 = ran.nextInt(11) + 5;
            hp1 -= attack2;
            if(hp1 < 0) hp1 = 0;
            System.out.println("玩家2攻击玩家1,玩家1的剩余血量为" + hp1);
            Thread.sleep(300);
            if(hp1 <= 0){
                System.out.println("玩家1死亡！！！");
                break;
            }
        }
        //宣布结果
        if(hp1 > 0){
            System.out.println("玩家1获胜！！！");
        }else{
            System.out.println("玩家2获胜！！！");
        }

        System.out.println("请输入任意键继续：");
        input.nextLine();
    }
}
