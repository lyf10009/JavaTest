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
        int j;
        for(int i=1;i<num.length;i++){
            if(num[i]<num[i-1]){
                int tmp=num[i];
                for(j=i-1;j>=0 && num[j]>tmp;j--){
                    num[j+1]=num[j];
                }
                num[j+1]=tmp;
            }
        }
        System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(num));
    }
}
