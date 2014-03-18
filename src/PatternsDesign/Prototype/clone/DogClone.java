package PatternsDesign.Prototype.clone;

public class DogClone implements Cloneable {
	/**
	 * 狗腿条数
	 */
	public int legCounts;
	/**
	 * 初始化一个狗
	 */
	Dog dog = new Dog(4);
	@Override
	protected DogClone clone() throws CloneNotSupportedException {
		//深拷贝
	    DogClone o = null;
		o = (DogClone)super.clone();
		o.dog = (Dog)dog.clone();
		return o;
		
		//浅拷贝
//	    return (DogClone)super.clone();
	}
}
