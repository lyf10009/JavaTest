package BasicApp;

public class CeilTest {

    public static void main(String[] args) {
//        ceil();
//        quzheng();
    }
    //ȡ�� ceil
    public static void ceil(){
        double num=1.55;
        
        //ǿ��ת�� int��ȥβ��
        System.out.println((int)num);
        
        //Math.ceil����һ��
        System.out.println(Math.ceil(num));
        
        //Math.round����������
        System.out.println(Math.round(num));
    } 
    //��10ȡ��
    public static void quzheng(){
        int i=233;
        
        System.out.println(Math.round(i/10.0)*10);
    }
}