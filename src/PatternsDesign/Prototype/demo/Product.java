package PatternsDesign.Prototype.demo;

import java.util.ArrayList;
import java.util.List;

public class Product implements Cloneable {
	/**
	 * ����һ
	 */
	private String property1;
	/**
	 * ���Զ�
	 */
	private String property2;
	/**
	 * ������
	 */
	private ArrayList<String> list=new ArrayList<String>();

	@Override
	public Product clone() throws CloneNotSupportedException {
	    //���
//	    Product product=null;
//	    product=(Product)super.clone();
//	    product.list=(ArrayList<String>) this.list.clone();
//		return product;
		//ǳ����
		return (Product)super.clone();
	}
	public String getProperty1() {
		return property1;
	}
	public void setProperty1(String property1) {
		this.property1 = property1;
	}
	public String getProperty2() {
		return property2;
	}
	public void setProperty2(String property2) {
		this.property2 = property2;
	}
	
	public void setValue(String value){
	    this.list.add(value);
	}
	public List<String> getValue(){
	    return this.list;
	}
}
