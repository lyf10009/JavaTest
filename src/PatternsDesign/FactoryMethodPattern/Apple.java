package PatternsDesign.FactoryMethodPattern;

/**
 * Æ»¹û
 */
public class Apple implements IFruit {
    private int treeAge;
    @Override
    public void plant() {
        // TODO Auto-generated method stub
        System.out.println("Apple has been planted.");
    }
    @Override
    public void grow() {
        // TODO Auto-generated method stub
        System.out.println("Apple is growing...");
    }
    @Override
    public void harvest() {
        // TODO Auto-generated method stub
        System.out.println("Apple has been harvested.");
    }
    public int getTreeAge() {
        return treeAge;
    }
    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }

}
