package com.collection;

public class Bus {
    private String bus1;
    private String bus2;
    private int bus3;
    private int bus4;
    public String getBus1() {
        return bus1;
    }
    public void setBus1(String bus1) {
        this.bus1 = bus1;
    }
    public String getBus2() {
        return bus2;
    }
    public void setBus2(String bus2) {
        this.bus2 = bus2;
    }
    public int getBus3() {
        return bus3;
    }
    public void setBus3(int bus3) {
        this.bus3 = bus3;
    }
    public int getBus4() {
        return bus4;
    }
    public void setBus4(int bus4) {
        this.bus4 = bus4;
    }
    public Bus(String bus1, String bus2, int bus3) {
        super();
        this.bus1 = bus1;
        this.bus2 = bus2;
        this.bus3 = bus3;
    }
    public Bus(String bus1, int bus3, int bus4) {
        super();
        this.bus1 = bus1;
        this.bus3 = bus3;
        this.bus4 = bus4;
    }
    public Bus() {
        super();
    }
    
}
