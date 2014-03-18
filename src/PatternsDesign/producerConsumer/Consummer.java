package PatternsDesign.producerConsumer;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;

public class Consummer implements Runnable {
    private BlockingQueue<String> queue;
    private int insertSQLTimes=0;
    private int times;
    public Consummer(BlockingQueue<String> queue,int times) {
        this.queue = queue;
        this.times = times;
    }

    @Override
    public void run() {
        String uuid;
        try {
            for(;insertSQLTimes<times;insertSQLTimes++){
                uuid = queue.take();
                System.out.println(Thread.currentThread() + " consume uuid:" + uuid+"  Ê±¼äÊÇ "+new Date());
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
