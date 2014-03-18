package PatternsDesign.AbstractFactory;

public class IntelCpu implements ICpu {
    private int pins=0;
    public IntelCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        // TODO Auto-generated method stub
        System.out.println("Intel CPUµÄÕë½ÅÊı£º"+pins);
    }
}
