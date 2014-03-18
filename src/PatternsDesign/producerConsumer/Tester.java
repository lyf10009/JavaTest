package PatternsDesign.producerConsumer;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public class Tester {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        // 队列
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(1);
        QueueInsert insertQueue = new QueueInsert(queue);

        // 消费者
        Consummer consumer = new Consummer(queue,15);
        
        for (int i = 0; i < 15; i++) {
            // 生产者一号
            Producer producer1 = new Producer(i);
            new Thread(producer1).start();
            producer1.addObserver(insertQueue);
//            Thread.sleep(2000);
        }
//
//        for (int i = 4; i < 8; i++) {
//            // 生产者二号
//            Producer producer2 = new Producer(i);
//            new Thread(producer2).start();
//            producer2.addObserver(insertQueue);
//        }
//
//        for (int i = 8; i < 12; i++) {
//            // 生产者三号
//            Producer producer3 = new Producer(i);
//            new Thread(producer3).start();
//            producer3.addObserver(insertQueue);
//        }
        new Thread(consumer).start();
    }

}
