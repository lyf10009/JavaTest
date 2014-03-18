package PatternsDesign.FactoryMethodPattern;

/**
 * 水果工厂接口
 */
public interface IFruitGardener {
    /**
     * 工厂方法
     * @return 水果
     */
    public IFruit factory();
}
