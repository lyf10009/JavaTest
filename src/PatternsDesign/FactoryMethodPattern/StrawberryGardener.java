package PatternsDesign.FactoryMethodPattern;

public class StrawberryGardener implements IFruitGardener {

    @Override
    public IFruit factory() {
        // TODO Auto-generated method stub
        IFruit f = new Strawberry();
        System.out.println("ˮ������(StrawberryGardener)�ɹ�������һ��ˮ������ݮ������");
        return f;
    }
}
