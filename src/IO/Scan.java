package IO;

import java.util.Scanner;

public class Scan {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
//		inputString(scanner);
		inputInteger(scanner);
		
	}
	public static void inputString(Scanner scanner){
	    System.out.println("������һ���ַ���");
	    String line=scanner.nextLine();
	    
	    char[] array=line.toCharArray();
	    for(int i=0;i<line.length();i++)
	    {
	        array[i]=(char)(array[i]^20000);
	    }
	    System.out.println("���ܽ���ǣ�");
	    System.out.println(new String(array));
	    
	    for(int i=0;i<line.length();i++)
	    {
	        array[i]=(char)(array[i]^20000);
	    }
	    System.out.println("���ܽ���ǣ�");
	    System.out.println(new String(array));
	}
	public static void inputInteger(Scanner scanner){
	    System.out.println("������3�����֣�");
	    int[] num=new int[3];
	    num[0]=scanner.nextInt();
	    num[1]=scanner.nextInt();
	    num[2]=scanner.nextInt();
	    System.out.println("����������ǣ�");
	    System.out.println(num[0]+"\t"+num[1]+"\t"+num[2]);
	}
}
