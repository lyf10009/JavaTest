package com.BasicApp;

import com.collection.Bus;

/**
 * 测试在函数内部改变参数值时，对参数的影响
 * @author fluo
 *
 */
public class ChangeValue {

	public static void main(String[] args) {
    	Bus one=new Bus("1", "2",3);
    	StringBuilder sBuilder = new StringBuilder("开始");
    	String str = "开始";
    	Integer index=1;
    	System.out.println(one);
    	System.out.println(str);
    	System.out.println(sBuilder.toString());
    	System.out.println(index);
    	
    	addOne(one, str,sBuilder,index);
    	
    	System.out.println(one);
    	System.out.println(str);
    	System.out.println(sBuilder.toString());
    	System.out.println(index);
    	
    	String[] array = new String[] {"huixin"};
    	System.out.println("调用reset方法前array中的第0个元素的值是:" + array[0]);
    	reset(array);
    	System.out.println("调用reset方法后array中的第0个元素的值是:" + array[0]);

    	//不变
    	String string = new String("huixin");
    	System.out.println("调用reset方法前string的值是:" + string);
    	reset(string);
    	System.out.println("调用reset方法后string的值是:" + string);

    	//不变
    	Integer num = new Integer(10);
    	System.out.println("调用reset方法前num的值是:" + num);
    	reset(num);
    	System.out.println("调用reset方法后num的值是:" + num);
    	 
	}

	public static void reset(String[] param) {
		param[0] = "hello, world!";
	}
	public static void reset(String param) {
		param += "hello, world!";
	}
	public static void reset(Integer param) {
		param += 1;
	}
    
    public static void addOne(Bus one,String str,StringBuilder sBuilder,Integer index){
    	one.setBus3(one.getBus3()+1);
    	str+="结束";
    	sBuilder.append("结束");
    	index++;
    } 

}
