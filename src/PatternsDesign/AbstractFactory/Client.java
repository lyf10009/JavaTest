package PatternsDesign.AbstractFactory;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ComputerEngineer cf = new ComputerEngineer();
        
        AbstractFactory af = new IntelFactory();
        cf.makeComputer(af);
    }

}
