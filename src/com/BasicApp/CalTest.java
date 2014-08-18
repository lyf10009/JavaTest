package com.BasicApp;

public class CalTest {
    public static void main(String[] args) {
        String[] nums={"1","2","3","4","5","6","7","8","9"};
//        fenbu(1,nums);
        jiajian(100,nums);
    }
    
    public static void jiajian(int result,String[] nums){
        int[] vals=new int[9];
        String[] fuhao={"+","-",""};
        StringBuilder sb1;
        for(int i=0;i<6561;){
            int tmp=0;
            String tmpStr="";
            sb1=new StringBuilder();
            for(int j=8;j>=0;j--){
                if(vals[j]==0){
                    if(tmpStr.isEmpty()){
                        tmp+=Integer.valueOf(nums[j]);
                    }else{
                        tmp+=Integer.valueOf(tmpStr);
                        tmpStr="";
                    }
                }else if(vals[j]==1){
                    if(tmpStr.isEmpty()){
                        tmp-=Integer.valueOf(nums[j]);
                    }else{
                        tmp-=Integer.valueOf(tmpStr);
                        tmpStr="";
                    }
                }else{
                    if(tmpStr.isEmpty()){
                        tmpStr=nums[j-1]+nums[j];
                    }else{
                        tmpStr=nums[j-1]+tmpStr;
                    }
                    
                }
            }
            
            if(tmp==result){
                for(int j=0;j<8;j++){
                    sb1.append(nums[j]).append(fuhao[vals[j+1]]);
                }
                sb1.append(nums[8]);
                System.out.println(sb1.toString()+"="+result);
            }
            
            i++;
            vals[8]=i;
            for(int j=7;j>=1;j--){
                vals[j]=vals[j+1]/3;
                vals[j+1]=vals[j+1]%3;
            }
            vals[1]=vals[1]%3;
        }
    }
    
    
    public static void fenbu(int result,String[] nums){
        int[] vals=new int[8];
        String[] fuhao={""," "};
        StringBuilder sb1;
        for(int i=0;i<256;){
            sb1=new StringBuilder();
            for(int j=0;j<8;j++){
                sb1.append(nums[j]).append(fuhao[vals[j]]);
            }
            sb1.append(nums[8]);
            String[] newNums=sb1.toString().split(" ");
            calculate(result,newNums);
            i++;
            vals[7]=i;
            for(int j=6;j>=0;j--){
                vals[j]=vals[j+1]/2;
                vals[j+1]=vals[j+1]%2;
            }
            vals[0]=vals[0]%2;
        }
    }
    
    
    public static void calculate(int result,String[] nums){
        int length=nums.length;
        if(length==1){
            if(result==Integer.valueOf(nums[0])){
                System.out.println(nums[0]+"="+result);
            }
            return;
        }
        int[] vals=new int[length-1];
        String[] fuhao={"+","-"};
        StringBuilder sb1;
        int size=(int) Math.pow(2,length-1);
        for(int i=0;i<size;){
            int tmp=Integer.valueOf(nums[0]);
            sb1=new StringBuilder();
            for(int j=length-1;j>0;j--){
                if(vals[j-1]==0){
                    tmp+=Integer.valueOf(nums[j]);
                }else{
                    tmp-=Integer.valueOf(nums[j]);
                }
            }
            
            if(tmp==result){
                for(int j=0;j<length-1;j++){
                    sb1.append(nums[j]).append(fuhao[vals[j]]);
                }
                sb1.append(nums[length-1]);
                System.out.println(sb1.toString()+"="+result);
            }
            
            i++;
            vals[length-2]=i;
            for(int j=length-3;j>=0;j--){
                vals[j]=vals[j+1]/2;
                vals[j+1]=vals[j+1]%2;
            }
            vals[0]=vals[0]%2;
        }
    }
}
