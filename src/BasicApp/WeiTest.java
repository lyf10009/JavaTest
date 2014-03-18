package BasicApp;

public class WeiTest {
    /**
     * 与（&），非（~），或（|），异或（^），<<表示左移
     */
    public static void main(String[] args) {
//        test();
//        changeValues();
//        findChessNum(5);
    }
    public static void findChessNum(int n) { 
        int num = 0; 
        while(n!=0){
            n&=n-1;
            num++; 
        } 
        System.out.println(num); 
    } 

    public static void changeValues(){
        int a=3;
        int b=4;
        System.out.println("交换前：a="+a+",b="+b);
        a^=b;
        b^=a;
        a^=b;
        //x=x+y;
        //y=x-y;   
        //x=x-y;
        
        //int[] arr={b,b=a};
        //a=arr[0];
        
        System.out.println("交换后：a="+a+",b="+b);
        
    }
    public static void test(){
        //方案2
        System.out.println("方案2");
        short startStation=10000;
        short endStation=2565;
        int station1=startStation<<16|endStation;
        System.out.println("将起点终点合并后："+station1);
        int startStation1=station1>>16;
        System.out.println("解析后的起点："+startStation1);
        int endStation1=station1&65535;
        System.out.println("解析后的终点："+endStation1);
        System.out.println();
        //方案3
        System.out.println("方案3");
        byte orderNumber=8;
        long station2=((long)startStation)<<24|(endStation<<8|orderNumber);
        System.out.println("将起点终点合并后："+station2);
        int startStation2=(int)(station2>>24);
        System.out.println("解析后的起点："+startStation2);
        int endStation2=(int)((station2>>8)&65535);
        System.out.println("解析后的终点："+endStation2);
        int orderNumber2=(int)(station2&255);
        System.out.println("解析后的orderNumber："+orderNumber2);
        System.out.println();
        //方案4
        System.out.println("方案4");
        String station3=Long.toString(((long)startStation)<<24|(endStation<<8|orderNumber));
        System.out.println("将起点终点合并后："+station3);
        int startStation3=(int)(Long.parseLong(station3)>>24);
        System.out.println("解析后的起点："+startStation3);
        int endStation3=(int)((Long.parseLong(station3)>>8)&65535);
        System.out.println("解析后的终点："+endStation3);
        int orderNumber3=(int)(Long.parseLong(station3)&255);
        System.out.println("解析后的orderNumber："+orderNumber3);
        System.out.println();
    }
}
