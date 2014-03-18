package PatternsDesign.Proxy;
/**
 * 
*定义一个美女A是什么样的人
 */
public class PanJinLian  implements KindWoman{
    @Override
    public void makeEyesWithMan() {
        System.out.println("美女A抛媚眼...");
    }
	@Override
	public void happyWithMan() {
		System.out.println("美女A在恋爱...");
	}
}