package PatternsDesign.FactoryMethodPattern;

/**
 * ����
 */
public class Grape implements IFruit {
    private boolean seedless;  //�Ƿ�����
    @Override
    public void plant() {
        // TODO Auto-generated method stub
        System.out.println("Grape has been planted.");
    }
    @Override
    public void grow() {
        // TODO Auto-generated method stub
        System.out.println("Grape is growing...");
    }
    @Override
    public void harvest() {
        // TODO Auto-generated method stub
        System.out.println("Grape has been harvested.");
    }
    public boolean isSeedless() {
        return seedless;
    }
    public void setSeedless(boolean seedless) {
        this.seedless = seedless;
    }
    /**
     * ��������
     */
    public static void log(String msg){
        System.out.println(msg);
    }
}
