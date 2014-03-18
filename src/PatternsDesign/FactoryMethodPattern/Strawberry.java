package PatternsDesign.FactoryMethodPattern;

/**
 * ��ݮ
 */
public class Strawberry implements IFruit {
    
    @Override
    public void plant() {
        // TODO Auto-generated method stub
        System.out.println("Strawberry has been planted.");
    }
    @Override
    public void grow() {
        // TODO Auto-generated method stub
        System.out.println("Strawberry is growing...");
    }
    @Override
    public void harvest() {
        // TODO Auto-generated method stub
        System.out.println("Strawberry has been harvested.");
    }

    /**
     * ��������
     */
    public static void log(String msg){
        System.out.println(msg);
    }
}
