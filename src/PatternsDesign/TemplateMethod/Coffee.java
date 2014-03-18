package PatternsDesign.TemplateMethod;

public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        // TODO Auto-generated method stub
        System.out.println("Dripping Coffee through filter!!!");
    }

    @Override
    void addCondiments() {
        // TODO Auto-generated method stub
        System.out.println("Adding Sugar and Milk!!!");
    }

}
