package com.BasicApp;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //获得0~x的随机数,不包括x
        int x=5;
        Random rand=new Random();
        /**
         * 创建的时候若赋初值 "47"（随机数生成器的种子），随机数生成器对于特定的种子值总是产生相同的随机序列
         */
        Random rand1=new Random(47);
        for(int i=0;i<20;i++){
            //方法一
            System.out.println(rand.nextInt(x));
            //方法二
            System.out.println((int)(Math.random()*x));

            
            System.out.println(rand1.nextInt(12));
        }
    }
}
