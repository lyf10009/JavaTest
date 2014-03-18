package PatternsDesign.FactoryMethodPattern;

public class TestApp {
    private IFruit p1,p2,p3;
    private IFruitGardener f1,f2,f3;
    private void test(){
        //ʵ����ˮ������
        f1 = new AppleGardener();
        f2 = new GrapeGrardener();
        f3 = new StrawberryGardener();
        //��ˮ����������ˮ��
        p1 = f1.factory();
        p2 = f2.factory();
        p3 = f3.factory();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestApp testApp = new TestApp();
        testApp.test();
    }

}
