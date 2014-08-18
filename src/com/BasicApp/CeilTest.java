package com.BasicApp;

public class CeilTest {

    public static void main(String[] args) {
//        ceil();
//        quzheng();
        
        int i=0;
        i=i++;
        System.out.println(i);
        
    }
    //取整 ceil
    public static void ceil(){
        double num=1.55;
        
        //强制转换 int：去尾法
        System.out.println((int)num);
        
        //Math.ceil：进一法
        System.out.println(Math.ceil(num));
        
        //Math.round：四舍五入
        System.out.println(Math.round(11.2));//11
        System.out.println(Math.round(11.5));//12
        System.out.println(Math.round(-11.5));//-11
        System.out.println(Math.round(-11.6));//-12
    } 
    //按10取整
    public static void quzheng(){
        int i=233;
        
        System.out.println(Math.round(i/10.0)*10);
    }
}
