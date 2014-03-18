package PatternsDesign.FactoryMethodPattern;

public class AppleGardener implements IFruitGardener {
    @Override
    public IFruit factory() {
        // TODO Auto-generated method stub
        IFruit f = new Apple();
        System.out.println("水果工厂(AppleGardener)成功创建了一个水果：苹果！！！");
        return f;
    }
}
