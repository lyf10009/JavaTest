package PatternsDesign.AbstractFactory;

public interface AbstractFactory {
    public ICpu createCpu();
    
    public IMainboard createMainboard();
}
