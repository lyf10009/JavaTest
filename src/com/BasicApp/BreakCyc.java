package com.BasicApp;

public class BreakCyc {

	public static void main(String[] args) {
		int[][] myScores=new int[][]{{67,78,63,22,66},{55,68,78,95,44},{95,97,92,93,81}};
		System.out.println("���Գɼ���\n��ѧ\t����\tӢ��\t����\t��ʷ");
		No1:for(int[] is:myScores)
		{
			for(int i:is)
			{
				System.out.print(" "+i+"\t");
				if(i<60)
				{
					System.out.println("\n�ȵȣ�"+i+"�ֵ���ʲô�����Ϊʲô������");
					break No1;
				}
			}
			System.out.println();
		}
	}
}
