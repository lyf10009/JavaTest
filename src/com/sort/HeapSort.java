package com.sort;

import java.util.Arrays;

/**
 * ������
 * @author Administrator
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] num={9,1,5,8,6,7,4,3,2,10,14,12};
        heapSort(num);
    }
    public static void heapSort(int[] num){
        int i;
        //�����󶥶�
        for(i=num.length/2-1;i>=0;i--){
            heapAdjust(num,i,num.length);
        }
        System.out.println("�󶥶ѣ�"+Arrays.toString(num));
        
        for(i=num.length-1;i>0;i--){
            int tmp=num[0];
            num[0]=num[i];
            num[i]=tmp;
            heapAdjust(num,0,i);
        }
        System.out.println("�����"+Arrays.toString(num));
    }
    //����
    public static void heapAdjust(int[] num,int index,int len){
        int tmp=num[index],j;
        for(j=index*2+1;j<len;){
            if(j<len-1 && num[j]<num[j+1]){//�ýڵ��������ӽڵ�
                j++;
            }
            if(tmp>=num[j]) break;
            num[index]=num[j];
            index=j;
            
            j=j*2+1;
        }
        num[index]=tmp;
    }
    //�ݹ�
    public static void heapAdjust1(int[] A,int idx,int max){
        int left = 2*idx+1;// ���ӵ��±꣨������ڵĻ���
        int right =2*idx+2;// �Һ��ӵ��±꣨������ڵĻ���
        int largest = 0;//Ѱ��3���ڵ������ֵ�ڵ���±�
        if(left<max && A[left]>A[idx])
            largest = left;
        else
            largest = idx;
        if(right<max && A[right]>A[largest]) largest = right;
        if(largest!=idx){
            swap(A,largest,idx);
            heapAdjust1(A,largest,max);            
        }    
    }
    public static void swap(int[] array,int i,int j){
        int temp =array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
