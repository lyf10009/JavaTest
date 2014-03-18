package PatternsDesign.TemplateMethod;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        // TODO Auto-generated method stub
        System.out.println("Steeping the tea!!!");
    }

    @Override
    void addCondiments() {
        // TODO Auto-generated method stub
        System.out.println("Adding Lemon!!!");
    }

}
