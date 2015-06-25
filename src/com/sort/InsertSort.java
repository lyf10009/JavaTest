package com.sort;

import java.util.Arrays;

/**
 * ≤Â»Î≈≈–Ú
 * O(n*n)
 * @author Administrator
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] num={9,1,5,8,3,7,4,6,2};
        insertSort(num);
    }
    public static void insertSort(int[] num){
        for(int i=0,j=i;i<num.length-1;j=++i){
        	int tmp = num[i + 1];
            while (tmp < num[j]) {
            	num[j + 1] = num[j];
                if (j-- == 0) {
                    break;
                }
            }
            num[j + 1] = tmp;
        }
        System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(num));
    }
}
