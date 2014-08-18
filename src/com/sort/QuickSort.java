package com.sort;

import java.util.Arrays;

/**
 * ��������
 * @author Administrator
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] num={9,1,5,8,6,7,4,3,2,10,14,12};
        quickSort(num);
    }
    public static void quickSort(int[] num){
        quickSort(num,0,num.length-1);
        System.out.println("�����"+Arrays.toString(num));
    }
    public static void quickSort(int[] num,int low,int high){
//        if(low<high){
//            int middle = partition(num,low,high);
//            quickSort(num,low,middle-1);
//            quickSort(num,middle+1,high);
//        }
        
        //β�ݹ��Ż�
        while(low<high){
            int middle = partition(num,low,high);
            quickSort(num, low, middle-1);
            low=middle+1;
        }
    }
    public static int partition(int[] num,int low,int high){
        //�Ż� 
        //����ȡ��(median-of-three)��ȡ�����ؼ����Ƚ������򣬽��м�����Ϊ��Ŧ��һ��ȡ��ˡ��Ҷˡ��м��������
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
