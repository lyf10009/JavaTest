package com.sort;

import java.util.Arrays;

/**
 * 选择排序，就是通过n-i次关键字间的比较，从n-i+1个记录中选出最小的记录，并和第i个记录交换
 * @author Administrator
 */
public class SimpleSelectionSort {

    public static void main(String[] args) {
        int[] num={9,1,5,8,3,7,4,6,2};
        selectSort(num);
    }
    //O(n*n)
    public static void selectSort(int[] num){
        int min;
        for(int i=0;i<num.length-1;i++){
            min=i;
            for(int j=i+1;j<num.length;j++){
                if(num[min]>num[j]){
                    min=j;
                }
            }
            if(i!=min){
                int tmp=num[i];
                num[i]=num[min];
                num[min]=tmp;
            }
        }
        System.out.println("排序后："+Arrays.toString(num));
    }
}
