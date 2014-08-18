package sort;

import java.util.Arrays;

/**
 * œ£∂˚≈≈–Ú
 * @author Administrator
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] num={9,1,5,8,3,7,4,6,2};
        shellSort(num);
    }
    public static void shellSort(int[] num){
        int len=num.length,j;
        while(len>1){
            len=len/3;
            for(int i=len;i<num.length;i++){
                if(num[i]<num[i-len]){
                    int tmp=num[i];
                    for(j=i-len;j>=0&&num[j]>tmp;j-=len){
                        num[j+len]=num[j];
                    }
                    num[j+len]=tmp;
                }
            }
        }
        System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(num));
    }
}
