package Josephu;

public class mainTest {
    /**
     * 丢手帕问题
     * 约瑟夫环是一个数学的应用问题：已知n个人(以编号1，2，3...n分别表示),围坐在一张圆桌周围。
     * 从编号为k的人开始报数，数到m的那个人出列;他的下一个人又从1开始报数，数到m的那个人又出列;
     * 依此规律重复下去，直到圆桌周围的人全部出列。
     */
    public static void main(String[] args) {
        Child head=null; 
        Child head_pointer=ChildService.createCircle(head, 5); 
        ChildService.outQueue(head_pointer, 2); 
    }
}
