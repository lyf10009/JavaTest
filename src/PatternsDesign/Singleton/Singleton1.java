package PatternsDesign.Singleton;

/**
 * 第一种形式: 懒汉式单例 线程不安全 可在getInstance方法前加 synchronized 关键字 解决线程不安全问题
 */
public class Singleton1 {
    private static Singleton1 instance = null;

    private Singleton1() {
        //do something
    }

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}


/**
 * 第二种形式: 饿汉式单例
 */
class Singleton2 {
    //在自己内部定义自己的一个实例，只供内部调用
    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {
        //do something
    }

    //这里提供了一个供外部访问本class的静态方法，可以直接访问
    public static Singleton2 getInstance() {
        return instance;
    }

    //类中其他方法，尽量使static
    public static void doSomething() {}
}


/**
 * 第三种形式: 双重锁的形式。
 * 这个模式将同步内容下方到if内部，提高了执行的效率，不必每次获取对象时都进行同步，
 * 只有第一次才同步，创建了以后就没必要了
 */
class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {
        //do something
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
