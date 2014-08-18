package com.BasicApp;

public class BreakCyc {

	public static void main(String[] args) {
		int[][] myScores=new int[][]{{67,78,63,22,66},{55,68,78,95,44},{95,97,92,93,81}};
		System.out.println("考试成绩：\n数学\t语文\t英语\t美术\t历史");
		No1:for(int[] is:myScores)
		{
			for(int i:is)
			{
				System.out.print(" "+i+"\t");
				if(i<60)
				{
					System.out.println("\n等等，"+i+"分的是什么？这个为什么不及格？");
					break No1;
				}
			}
			System.out.println();
		}
	}
}
