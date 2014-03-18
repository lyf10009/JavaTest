package PatternsDesign.AbstractFactory;

public class AmdMainboard implements IMainboard {
    private int cpuHoles=0;
    public AmdMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("AMD�����CPU��ۿ����ǣ�"+cpuHoles);
    }

}
