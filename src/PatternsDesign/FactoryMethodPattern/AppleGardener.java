package PatternsDesign.FactoryMethodPattern;

public class AppleGardener implements IFruitGardener {
    @Override
    public IFruit factory() {
        // TODO Auto-generated method stub
        IFruit f = new Apple();
        System.out.println("ˮ������(AppleGardener)�ɹ�������һ��ˮ����ƻ��������");
        return f;
    }
}
