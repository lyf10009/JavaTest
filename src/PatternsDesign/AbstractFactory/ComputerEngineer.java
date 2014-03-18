package PatternsDesign.AbstractFactory;

public class ComputerEngineer {
    private ICpu cpu =null;
    private IMainboard mainboard= null;
    public void makeComputer(AbstractFactory af){
        prepareHardwares(af);
    }
    private void prepareHardwares(AbstractFactory af){
        /**
         * ����Ҫȥ׼��CPU ������ľ���ʵ�֣�Ϊ��ʾ���򵥣�����ֻ׼������
         * ����װ������ʦ����֪�����ȥ��������ô�죿
         * ֱ������Ӧ�Ĺ�����ȡ
         */
        this.cpu = af.createCpu();
        this.mainboard = af.createMainboard();
        //��������Ƿ����
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
