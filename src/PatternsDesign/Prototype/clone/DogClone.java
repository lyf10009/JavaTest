package PatternsDesign.Prototype.clone;

public class DogClone implements Cloneable {
	/**
	 * ��������
	 */
	public int legCounts;
	/**
	 * ��ʼ��һ����
	 */
	Dog dog = new Dog(4);
	@Override
	protected DogClone clone() throws CloneNotSupportedException {
		//���
	    DogClone o = null;
		o = (DogClone)super.clone();
		o.dog = (Dog)dog.clone();
		return o;
		
		//ǳ����
//	    return (DogClone)super.clone();
	}
}
