package PatternsDesign.FactoryMethodPattern;

public class GrapeGrardener implements IFruitGardener {

    @Override
    public IFruit factory() {
        // TODO Auto-generated method stub
        IFruit f = new Grape();
        System.out.println("水果工厂(GrapeGardener)成功创建了一个水果：葡萄！！！");
        return f;
    }

}
