package com.BasicApp;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //���0~x�������,������x
        int x=5;
        Random rand=new Random();
        /**
         * ������ʱ��������ֵ "47"������������������ӣ�������������������ض�������ֵ���ǲ�����ͬ���������
         */
        Random rand1=new Random(47);
        for(int i=0;i<20;i++){
            //����һ
            System.out.println(rand.nextInt(x));
            //������
            System.out.println((int)(Math.random()*x));

            
            System.out.println(rand1.nextInt(12));
        }
    }
}
