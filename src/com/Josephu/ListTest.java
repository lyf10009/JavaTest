package com.Josephu;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        tieShoupa(5,2,2);
    }
    
    public static void tieShoupa(int n,int k,int m){
        List<Integer> childen = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            childen.add(i);
        }
        int head=k-1;
        for(int i=0;i<n-1;i++){
            int no = (head+m-1)%(childen.size());
            System.out.println(childen.get(no)+"-->");
            childen.remove(no);
            head=no;
        }
        System.out.println(childen.get(0));
    }

}
