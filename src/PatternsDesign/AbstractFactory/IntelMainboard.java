package PatternsDesign.AbstractFactory;

public class IntelMainboard implements IMainboard {
    private int cpuHoles=0;
    public IntelMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }
    @Override
    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("Intel�����CPU��ۿ����ǣ�"+cpuHoles);
    }

}
