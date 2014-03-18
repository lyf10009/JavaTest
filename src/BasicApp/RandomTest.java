package BasicApp;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        //获得0~x的随机数,不包括x
        int x=5;
        Random rand=new Random();
        for(int i=0;i<20;i++){
            //方法一
            System.out.println(rand.nextInt(x));
            //方法二
            System.out.println((int)(Math.random()*x));
        }
    }
}
