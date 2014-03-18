package PatternsDesign.FactoryMethodPattern;

/**
 * Read Me : 水果接口
 */
public interface IFruit {
    /**
     * 种植
     */
    void plant();
    /**
     * 生长
     */
    void grow();
    /**
     * 收获
     */
    void harvest();
}
