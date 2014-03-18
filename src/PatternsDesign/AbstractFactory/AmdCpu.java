package PatternsDesign.AbstractFactory;

public class AmdCpu implements ICpu {
    private int pins=0;
    public AmdCpu(int pins){
        this.pins = pins;
    }
    @Override
    public void calculate() {
        // TODO Auto-generated method stub
        System.out.println("AMD CPUµÄÕë½ÅÊı£º"+pins);
    }
}
