package PatternsDesign.Proxy;
/**
 * 
*����һ��C��ʲô������
 */
public class JiaShi implements KindWoman {

    @Override
    public void makeEyesWithMan() {
        System.out.println("C������...");
        
    }
	@Override
	public void happyWithMan() {
		System.out.println("C������������...");
	}
}
