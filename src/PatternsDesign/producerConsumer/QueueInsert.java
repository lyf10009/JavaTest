package PatternsDesign.producerConsumer;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;

public class QueueInsert implements Runnable, Observer {//extends Observable
    private BlockingQueue<String> queue;
    private int insertTimes = 0;
    private String str;

    public QueueInsert(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void update(Observable o, Object arg) {
        setStr((String) arg);
        run();
    }

    @Override
    public void run() {
        try {
            queue.put(str);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        insertTimes++;
        System.out.println("队列中的文件数是："+queue.size()+"  //////  "+insertTimes+"  时间是"+new Date());
//            setChanged();
//            notifyObservers();
        
    }

}
