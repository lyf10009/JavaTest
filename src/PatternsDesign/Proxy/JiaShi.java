package PatternsDesign.Proxy;
/**
 * 
*定义一个C是什么样的人
 */
public class JiaShi implements KindWoman {

    @Override
    public void makeEyesWithMan() {
        System.out.println("C抛媚眼...");
        
    }
	@Override
	public void happyWithMan() {
		System.out.println("C和男人在恋爱...");
	}
}
