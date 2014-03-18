package PatternsDesign.FactoryMethodPattern;

public class StrawberryGardener implements IFruitGardener {

    @Override
    public IFruit factory() {
        // TODO Auto-generated method stub
        IFruit f = new Strawberry();
        System.out.println("水果工厂(StrawberryGardener)成功创建了一个水果：草莓！！！");
        return f;
    }
}
