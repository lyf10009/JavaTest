package BasicApp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {

    public static void main(String[] args) throws ParseException {
//        judgeChinese();//�жϺ��ָ���
//        removeStr();
//        timeFormatByString();
//        substringTest();
//        compareToStr();
//        replaceString();
//        match();
//        splitTest();
    }
    public static void splitTest(){
        String str1="123,1231";
        String str2="12313";
        String[] arr1=str1.split(",");
        String[] arr2=str2.split(",");
        for(String he:arr1){
            System.out.println(he);
        }
        System.out.println("-------------------------"+arr1.length);
        for(String he:arr2){
            System.out.println(he);
        }
        System.out.println("-------------------------"+arr2.length);
        
    }
    public static void match(){
        String string="static_shortest_time_night-0-1";
        if(string.endsWith("-1")) System.out.println("�ַ�����'-1'��β");
        if(string.startsWith("static")) System.out.println("�ַ�����'static'��ͷ");
        
        if(string.indexOf("night")>=0) {
            System.out.println("�ַ�������'night'");
        }else{
            System.out.println("�ַ���������'night'");
        }
    }
    public static void replaceString(){
        String str1 = "luo123luo456fei789";
        String str2 = str1.replaceAll("ren","");
        String str3 = str1.replaceAll("luo","");
        System.out.println(str2);
        System.out.println(str3);
    }
    public static void compareToTest(){
        String str1 = "6001";
        String str2 = "6002";
        String str3 = "6001";
        System.out.println(str1.compareTo(str2));//-1
        System.out.println(str2.compareTo(str1));//1
        System.out.println(str1.compareTo(str3));//0
    }
    public static void charAtTest(){
        String str="0123456789";
        System.out.println("charAt������"+str.charAt(8));          //index��0��ʼ
    }
    public static void substringTest(){
        String str="123456789";
        //substring(int index[,int toIndex]),index��0��ʼ,Ĭ�ϵ��ַ���ĩβ
        System.out.println(str.substring(0, 7));
        System.out.println(str.substring(3, str.length()-2));
        System.out.println(str.substring(5));
        System.out.println(str.substring(7,8));
    }
    //ͨ���ַ���ʱ�� ����ʱ���  ��
    public static void timeFormatByString() throws ParseException {
        DateFormat df=new SimpleDateFormat("HH:mm:ss");
        DateFormat df1=new SimpleDateFormat("HH:mm");
        DateFormat dfAll=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dfMonthDay=new SimpleDateFormat("MM-dd");
        DateFormat dfYear=new SimpleDateFormat("yyyy-MM-dd");

        String str1="2013-4-01 17:30:42.0";
        String str11="2013-4-01 17:30:43.0";
        Date as1=new Date();
        as1=dfAll.parse(str1);
        String str2="7:55";
        System.out.println(as1.equals(dfAll.parse(str1)));
        System.out.println(dfYear.parse(dfYear.format(dfAll.parse(str1))));
        System.out.println(df.format(df1.parse(str2).getTime()));
        System.out.println(df1.format(df1.parse(str2).getTime()));
        System.out.println(df1.format(df.parse(str1).getTime()));
        System.out.println(df.format(df.parse(str1).getTime()));
    }
    //�жϺ��ָ���
    public static void judgeChinese(){
        int count = 0;
        String str = "����fd�����й���as�ĵ�·վasdsa";
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while(m.find()) {
            count = count + 1;
        }
        System.out.println("���� " + count + "�� ");
        System.out.println();
    }
    
    //ɾ���ض��ַ�
    public static void removeStr(){
        String str="����fb9da�����й���9bsasb9dsa";
        System.out.println(str+"  "+str.length());
        String str1 = new String();
        String[] arrStrings=str.split("b");//split(string)�������ض��ַ����ַ�������Ϊ�ַ������飬���ж���ַ�������("|")����������split(",|-")
        for(String a:arrStrings){
            System.out.print(a);
            str1+=a;
        }
        System.out.println(str1.length());
    }
}