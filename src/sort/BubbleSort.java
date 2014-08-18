package sort;

import java.util.Arrays;

/**
 * √∞≈›≈≈–Ú
 * @author Administrator
 */
public class BubbleSort {
    
    public static void bubbleSort0(int[] num){
        for(int i=0;i<num.length-1;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]>num[j]){
                    int tmp=num[i];
                    num[i]=num[j];
                    num[j]=tmp;
                }
            }
        }
        System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(num));
    }
    
    //√∞≈›≈≈–Ú
    public static void bubbleSort1(int[] num){
        for(int i=0;i<num.length-1;i++){
            for(int j=num.length-2;j>=i;j--){
                if(num[j]>num[j+1]){
                    int tmp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=tmp;
                }
            }
        }
        System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(num));
    }

    //∏ƒΩ¯∫Ûµƒ√∞≈›≈≈–Ú
    public static void bubbleSort2(int[] num){
        boolean flag=true;
        for(int i=0;i<num.length-1 && flag;i++){
            flag = false;
            for(int j=num.length-2;j>=i;j--){
                if(num[j]>num[j+1]){
                    int tmp=num[j];
                    num[j]=num[j+1];
                    num[j+1]=tmp;
                    flag = true;
                }
            }
        }
        System.out.println("≈≈–Ú∫Û£∫"+Arrays.toString(num));
    }
    
    
    public static void main(String[] args) {
        int[] num={9,1,5,8,3,7,4,6,2};
//        bubbleSort0(num);
//        bubbleSort1(num);
        bubbleSort2(num);
    }

}
