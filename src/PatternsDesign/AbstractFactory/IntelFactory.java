package PatternsDesign.AbstractFactory;

public class IntelFactory implements AbstractFactory {

    @Override
    public ICpu createCpu() {
        // TODO Auto-generated method stub
        return new IntelCpu(755);
    }

    @Override
    public IMainboard createMainboard() {
        // TODO Auto-generated method stub
        return new IntelMainboard(755);
    }

}
