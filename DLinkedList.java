import java.util.*;
public class DLinkedList {
    class Node{
        Node prev;
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public Node head=null;
    public Node tail=null;
    public void addnode(int data){
        Node newNode=new Node(data);
        if(head==null){
                head=newNode;
                tail=newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }
    public void display(){
        Node temp=head;
        System.out.println("////----------------------------------------------------------------------------////");
        if(head==null){
            System.out.println("No element to print");
        }
        
        else{
            while(temp!=null){
                System.out.print("\t"+temp.data);
                temp=temp.next;
                
            }System.out.println("\n");
        }
        System.out.println("////--------------------------------------------------------------------------////");
    }
    public void delete(int data){
        Node temp=head;
        if(temp!=null && temp.data==data){
            head=temp.next;
            return;
        }
        while(temp!=null && temp.data!=data){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Elements Not found");
        }
        else if(temp==tail){
            tail=temp.prev;
            tail.next=null;
        }
        else{
            Node back=temp.prev;
            back.next=temp.next;
            
        }
    }
    public void insertpos(int nexto,int data){
        Node temp=head;
        Node newNode=new Node(data);
        while(temp!=null && temp.data!=nexto){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("element next to not found");

        }
        else if(temp==tail){
            tail.next=newNode;
            tail=newNode;
        }
        else{
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    public void displayrev(){
        Node temp=tail;
        System.out.println("////----------------------------------------------------------------------------////");
        if(head==null){
            System.out.println("No element to print");
        }
        
        else{
            while(temp!=null){
                System.out.print("\t"+temp.data);
                temp=temp.prev;
                
            }System.out.println("\n");
        }
        System.out.println("////--------------------------------------------------------------------------////");
    }
    public static void main(String arg[]) {
        DLinkedList list=new DLinkedList();
        Scanner sc=new Scanner(System.in);
        int data=0;
        outloop:
        while(true){
            System.out.println(" 1 For adding elements \n 2 For Display \n 3 For Display reverse \n 4 For dleteing element \n % for inserting after");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter the element");
                    data=sc.nextInt();
                    list.addnode(data);
                    break;
                case 2:
                    System.out.println("Elements are");
                    list.display();
                    break;
                case 3:
                    System.out.println("Elements are reverse");
                    list.displayrev();
                    break;
                case 4:
                    System.out.println("Elements to be deleted");
                    data=sc.nextInt();
                    list.delete(data);
                    break;
                case 5:
                    System.out.println("Enter the next to value");
                    int nexto=sc.nextInt();
                    System.out.println("Enter value");
                    data=sc.nextInt();
                    list.insertpos(nexto, data);
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break outloop;
                
            }
        }
    }
}
