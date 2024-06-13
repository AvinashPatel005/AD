package lab2;
class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
public class HashTableSC {
    Node[] hashtable;
    int size;
    int items;
    static int NULL = Integer.MIN_VALUE;

    public HashTableSC(int size) {
        this.hashtable = new Node[size];
        this.size = size;
        this.items = 0;
        for (int i = 0; i < size; i++) {
            hashtable[i]=new Node(NULL);
        }
    }
    public void insert(int num){
        int i=num%size;
        if(i<0) i=-i;
        Node n = hashtable[i];
        Node newNode = new Node(num);
        newNode.next=n;
        hashtable[i]=newNode;
    }
    public void display() {
        for(int i=0;i<hashtable.length;i++) {
            Node ptr=hashtable[i];
            System.out.print("Index "+i+":");
            while(ptr.next!=null) {
                System.out.print(ptr.value+"-->");
                ptr=ptr.next;
            }
            System.out.println();
        }
        System.out.println("___________________");
    }

    public static void main(String[] args) {
        int arr[]= {42,10,5,15,-12,21,28};
        HashTableSC hashtable = new HashTableSC(4);
        for(int i:arr){
            hashtable.insert(i);
            hashtable.display();
        }
    }
}
