package PatternsDesign.FactoryMethodPattern;

public class GrapeGrardener implements IFruitGardener {

    @Override
    public IFruit factory() {
        // TODO Auto-generated method stub
        IFruit f = new Grape();
        System.out.println("ˮ������(GrapeGardener)�ɹ�������һ��ˮ�������ѣ�����");
        return f;
    }

}
