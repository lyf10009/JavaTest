package Josephu;

public class mainTest {
    /**
     * ����������
     * Լɪ����һ����ѧ��Ӧ�����⣺��֪n����(�Ա��1��2��3...n�ֱ��ʾ),Χ����һ��Բ����Χ��
     * �ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳���;������һ�����ִ�1��ʼ����������m���Ǹ����ֳ���;
     * ���˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�
     */
    public static void main(String[] args) {
        Child head=null; 
        Child head_pointer=ChildService.createCircle(head, 5); 
        ChildService.outQueue(head_pointer, 2); 
    }
}
