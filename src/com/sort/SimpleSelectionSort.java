package com.sort;

import java.util.Arrays;

/**
 * ѡ�����򣬾���ͨ��n-i�ιؼ��ּ�ıȽϣ���n-i+1����¼��ѡ����С�ļ�¼�����͵�i����¼����
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
        System.out.println("�����"+Arrays.toString(num));
    }
}
