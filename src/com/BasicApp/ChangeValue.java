package com.BasicApp;

import com.collection.Bus;

/**
 * �����ں����ڲ��ı����ֵʱ���Բ�����Ӱ��
 * @author fluo
 *
 */
public class ChangeValue {

	public static void main(String[] args) {
    	Bus one=new Bus("1", "2",3);
    	StringBuilder sBuilder = new StringBuilder("��ʼ");
    	String str = "��ʼ";
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
    	System.out.println("����reset����ǰarray�еĵ�0��Ԫ�ص�ֵ��:" + array[0]);
    	reset(array);
    	System.out.println("����reset������array�еĵ�0��Ԫ�ص�ֵ��:" + array[0]);

    	//����
    	String string = new String("huixin");
    	System.out.println("����reset����ǰstring��ֵ��:" + string);
    	reset(string);
    	System.out.println("����reset������string��ֵ��:" + string);

    	//����
    	Integer num = new Integer(10);
    	System.out.println("����reset����ǰnum��ֵ��:" + num);
    	reset(num);
    	System.out.println("����reset������num��ֵ��:" + num);
    	 
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
    	str+="����";
    	sBuilder.append("����");
    	index++;
    } 

}
