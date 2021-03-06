package PatternsDesign.Proxy;

public class WangPo implements KindWoman {
	
	private KindWoman kindWoman;
	public WangPo(){
		//默认的话是美女A的代理
		this.kindWoman = new PanJinLian();
	}
	//她可以是KindWomam的任何一个女人的代理，只要你是这一类型
	public WangPo(KindWoman kindWoman){
		this.kindWoman = kindWoman;
	}
	@Override
	public void makeEyesWithMan() {
	    //B年纪大了，谁看她抛媚眼啊
	    this.kindWoman.makeEyesWithMan();
	}
	@Override
	public void happyWithMan() {
		//自己老了，干不了了，但可以叫年轻的代替。
		this.kindWoman.happyWithMan();
	}
}
