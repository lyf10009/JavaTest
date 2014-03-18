package PatternsDesign.AbstractFactory;

public class AmdFactory implements AbstractFactory {

    @Override
    public ICpu createCpu() {
        // TODO Auto-generated method stub
        return new AmdCpu(938);
    }

    @Override
    public IMainboard createMainboard() {
        // TODO Auto-generated method stub
        return new AmdMainboard(938);
    }

}
