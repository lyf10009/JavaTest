package PatternsDesign.Singleton;

/**
 * ��һ����ʽ: ����ʽ���� �̲߳���ȫ ����getInstance����ǰ�� synchronized �ؼ��� ����̲߳���ȫ����
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
 * �ڶ�����ʽ: ����ʽ����
 */
class Singleton2 {
    //���Լ��ڲ������Լ���һ��ʵ����ֻ���ڲ�����
    private static final Singleton2 instance = new Singleton2();

    private Singleton2() {
        //do something
    }

    //�����ṩ��һ�����ⲿ���ʱ�class�ľ�̬����������ֱ�ӷ���
    public static Singleton2 getInstance() {
        return instance;
    }

    //������������������ʹstatic
    public static void doSomething() {}
}


/**
 * ��������ʽ: ˫��������ʽ��
 * ���ģʽ��ͬ�������·���if�ڲ��������ִ�е�Ч�ʣ�����ÿ�λ�ȡ����ʱ������ͬ����
 * ֻ�е�һ�β�ͬ�����������Ժ��û��Ҫ��
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
