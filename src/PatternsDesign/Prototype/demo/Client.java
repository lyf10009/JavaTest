package PatternsDesign.Prototype.demo;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Product product = new Product();
		product.setProperty1("原始产品的属性一特性");
		product.setProperty2("原始产品的属性二特性");
		product.setValue("张三");
		System.out.println("原始产品===属性一："+product.getProperty1());
		System.out.println("原始产品===属性二："+product.getProperty2());
		System.out.println("原始产品===list："+product.getValue());
		
		System.out.println("-----------------------------------------------------------");
		
		Product productClone = (Product)product.clone();
		productClone.setProperty1("原始产品的克隆属性一特性");
		productClone.setValue("李斯");
		System.out.println("原始产品的克隆产品的属性一："+productClone.getProperty1());
		System.out.println("原始产品的克隆产品的属性二："+productClone.getProperty2());
		System.out.println("原始产品的克隆产品list："+productClone.getValue());

		System.out.println("原始产品===list："+product.getValue());
		System.out.println("-----------------------------------------------------------");
		
		Product product1 = new Product1();
		System.out.println("产品一属性一："+product1.getProperty1());
		System.out.println("产品一属性二："+product1.getProperty2());
		
		System.out.println("-----------------------------------------------------------");

		Product product2 = (Product)product.clone();
		System.out.println("产品二属性一："+product2.getProperty1());
		System.out.println("产品二属性二："+product2.getProperty2());
	}
}
