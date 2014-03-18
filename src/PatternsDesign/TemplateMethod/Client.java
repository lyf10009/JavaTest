package PatternsDesign.TemplateMethod;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Tea myTea = new Tea();
        myTea.prepareRecipe();
        System.out.println("----------------------------------");
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
