package PatternsDesign.Proxy;
/**
 * 
*����һ����ŮA��ʲô������
 */
public class PanJinLian  implements KindWoman{
    @Override
    public void makeEyesWithMan() {
        System.out.println("��ŮA������...");
    }
	@Override
	public void happyWithMan() {
		System.out.println("��ŮA������...");
	}
}