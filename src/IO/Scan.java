package IO;

import java.util.Scanner;

public class Scan {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
//		inputString(scanner);
		inputInteger(scanner);
		
	}
	public static void inputString(Scanner scanner){
	    System.out.println("请输入一串字符：");
	    String line=scanner.nextLine();
	    
	    char[] array=line.toCharArray();
	    for(int i=0;i<line.length();i++)
	    {
	        array[i]=(char)(array[i]^20000);
	    }
	    System.out.println("加密结果是：");
	    System.out.println(new String(array));
	    
	    for(int i=0;i<line.length();i++)
	    {
	        array[i]=(char)(array[i]^20000);
	    }
	    System.out.println("解密结果是：");
	    System.out.println(new String(array));
	}
	public static void inputInteger(Scanner scanner){
	    System.out.println("请输入3个数字：");
	    int[] num=new int[3];
	    num[0]=scanner.nextInt();
	    num[1]=scanner.nextInt();
	    num[2]=scanner.nextInt();
	    System.out.println("输入的数字是：");
	    System.out.println(num[0]+"\t"+num[1]+"\t"+num[2]);
	}
}
