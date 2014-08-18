package com.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author Administrator
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] num={9,1,5,8,6,7,4,3,2,10,14,12};
        quickSort(num);
    }
    public static void quickSort(int[] num){
        quickSort(num,0,num.length-1);
        System.out.println("排序后："+Arrays.toString(num));
    }
    public static void quickSort(int[] num,int low,int high){
//        if(low<high){
//            int middle = partition(num,low,high);
//            quickSort(num,low,middle-1);
//            quickSort(num,middle+1,high);
//        }
        
        //尾递归优化
        while(low<high){
            int middle = partition(num,low,high);
            quickSort(num, low, middle-1);
            low=middle+1;
        }
    }
    public static int partition(int[] num,int low,int high){
        //优化 
        //三数取中(median-of-three)：取三个关键字先进行排序，将中间数作为枢纽，一般取左端、右端、中间的三个数
        int m=low+(high-low)/2;
        if(num[low]>num[high]) swap(num, low,high);
        if(num[m]>num[high]) swap(num, m,high);
        if(num[m]>num[low]) swap(num, low,m);
        
        int tmp = num[low];
        while(low < high){
            while(low<high && num[high]>tmp){
               high--; 
            }
            num[low]=num[high];
            while(low<high && num[low]<=tmp){
                low++; 
            }
            num[high]=num[low];
        }
        num[low]=tmp;
        return low;
    }
    private static void swap(int[] num,int i,int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
}
