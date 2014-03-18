package Josephu;

public class ChildService {

    public static Child createCircle(Child head, int totalChild) {
        Child currentChild=null;
        for(int i=1;i<=totalChild;i++){
            Child tmp= new Child(i);
            if(i==1){
                head=tmp;
                currentChild=tmp;
                currentChild.setNextChild(head);
            }else{
                currentChild.setNextChild(tmp);
                currentChild=currentChild.getNextChild();
                currentChild.setNextChild(head);
            }
        }
        return head;
    }

    public static void outQueue(Child head, int no) {
        Child currentChild = head;
        Child prioChild =null;
        while(currentChild!=currentChild.getNextChild()){
            for(int i=1;i<no;i++){
                prioChild=currentChild;
                currentChild=currentChild.getNextChild();
            }
            System.out.println(currentChild.getNumber()+"-->");
            prioChild.setNextChild(currentChild.getNextChild());
            currentChild=prioChild.getNextChild();
        }
        System.out.println(currentChild.getNumber());
    }

}
