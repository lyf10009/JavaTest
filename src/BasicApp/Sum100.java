package BasicApp;

import java.util.ArrayList;
import java.util.List;

public class Sum100 {

    private char[] digits = new char[]{'1','2','3','4','5','6','7','8','9'};
    private String[] ops = new String[]{"+","-",""};
    private static int SUM = 100;
    public void sum(int index,String expr){
        if(index==8){
            int a = eval(expr);
            if(a==SUM){
                System.out.printf(expr+"=%d\n",SUM);
            }
        }else{
            for(int i=0;i<ops.length;i++){
                sum(index+1,expr+ops[i]+digits[index+1]);
            }
        }
    }
    
    public Integer eval(String expr){//heh
        String[] numbers = expr.split("[+-]");//按"+-"划分
        String[] operators = expr.split("\\d+");//按数字划分
        operators = filter(operators);
        int result = Integer.parseInt(numbers[0]);
        for(int i=0;i<operators.length;i++){
            if(operators[i].equals("+")){
                result += Integer.parseInt(numbers[i+1]); 
            }else if(operators[i].equals("-")){
                result -= Integer.parseInt(numbers[i+1]); 
            }else{
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
    private String[] filter(String[] operators) {
        List<String> ops = new ArrayList<String>();
        for(int i=0;i<operators.length;i++){
            if(!operators[i].equals("")){
                ops.add(operators[i]);
            }
        }
        return ops.toArray(new String[]{});
    }


    public static void main(String[] args) {
        new Sum100().sum(0, "1");
    }

}


