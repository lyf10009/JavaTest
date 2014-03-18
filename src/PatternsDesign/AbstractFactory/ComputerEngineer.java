package PatternsDesign.AbstractFactory;

public class ComputerEngineer {
    private ICpu cpu =null;
    private IMainboard mainboard= null;
    public void makeComputer(AbstractFactory af){
        prepareHardwares(af);
    }
    private void prepareHardwares(AbstractFactory af){
        /**
         * 这里要去准备CPU 和主板的具体实现，为了示例简单，这里只准备两个
         * 但是装机工程师并不知道如何去创建，怎么办？
         * 直接找相应的工厂获取
         */
        this.cpu = af.createCpu();
        this.mainboard = af.createMainboard();
        //测试配件是否好用
        this.cpu.calculate();
        this.mainboard.installCPU();
    }
}
