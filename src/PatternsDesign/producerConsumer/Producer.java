package PatternsDesign.producerConsumer;

import java.util.Date;
import java.util.Observable;
import java.util.UUID;

public class Producer extends Observable implements Runnable {
    private int i;
    public Producer(int i){
        this.i=i;
    }
    @Override
    public void run() {
        String uuid = UUID.randomUUID().toString()+"  "+i;
        setChanged();
        notifyObservers(uuid);
        System.out.println(new Date());
    }
}
