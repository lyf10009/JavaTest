package PatternsDesign.Prototype.demo;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		Product product = new Product();
		product.setProperty1("ԭʼ��Ʒ������һ����");
		product.setProperty2("ԭʼ��Ʒ�����Զ�����");
		product.setValue("����");
		System.out.println("ԭʼ��Ʒ===����һ��"+product.getProperty1());
		System.out.println("ԭʼ��Ʒ===���Զ���"+product.getProperty2());
		System.out.println("ԭʼ��Ʒ===list��"+product.getValue());
		
		System.out.println("-----------------------------------------------------------");
		
		Product productClone = (Product)product.clone();
		productClone.setProperty1("ԭʼ��Ʒ�Ŀ�¡����һ����");
		productClone.setValue("��˹");
		System.out.println("ԭʼ��Ʒ�Ŀ�¡��Ʒ������һ��"+productClone.getProperty1());
		System.out.println("ԭʼ��Ʒ�Ŀ�¡��Ʒ�����Զ���"+productClone.getProperty2());
		System.out.println("ԭʼ��Ʒ�Ŀ�¡��Ʒlist��"+productClone.getValue());

		System.out.println("ԭʼ��Ʒ===list��"+product.getValue());
		System.out.println("-----------------------------------------------------------");
		
		Product product1 = new Product1();
		System.out.println("��Ʒһ����һ��"+product1.getProperty1());
		System.out.println("��Ʒһ���Զ���"+product1.getProperty2());
		
		System.out.println("-----------------------------------------------------------");

		Product product2 = (Product)product.clone();
		System.out.println("��Ʒ������һ��"+product2.getProperty1());
		System.out.println("��Ʒ�����Զ���"+product2.getProperty2());
	}
}