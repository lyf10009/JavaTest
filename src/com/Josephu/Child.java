package com.Josephu;

public class Child {
    private int number;
    private Child nextChild;
    public Child(int number){
        this.number=number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Child getNextChild() {
        return nextChild;
    }
    public void setNextChild(Child nextChild) {
        this.nextChild = nextChild;
    }
    
}
