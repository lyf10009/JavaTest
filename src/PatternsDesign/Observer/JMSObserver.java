package PatternsDesign.Observer;

import java.util.Observable;
import java.util.Observer;

public class JMSObserver implements Observer{

	public void update(Observable o, Object arg) {
		System.out.println("������Ϣ��JMS�������Ĺ۲����Ѿ���ִ��");
	}
}