package lab2;

import java.util.Scanner;

public class HashTableQP {
    int[] hashtable;
    int size;
    int items;
    static int NULL = Integer.MIN_VALUE;
    public HashTableQP(int num){
        this.hashtable = new int[num];
        for (int i = 0; i < num; i++) {
            hashtable[i]=NULL;
        }
        this.size=num;
        this.items=0;
    }
    public void insert(int num){
        if(items==size){
            System.out.println("HashTable is Full");
            return;
        }
        int i = num%size;
        if(i<0) i = -i;
        if(hashtable[i]==NULL){
            hashtable[i]=num;
            items++;
        }
        else{
            int x=collision(i);
            if(x==-1){
                System.out.println("No place");
                return;
            }
            if(x!=i) items++;
            hashtable[x]=num;
        }
    }
    public int collision(int i){
        int val = hashtable[i];
        int j=1;
        int check=i;
        while (val!=NULL){
            System.out.println(j);
            check=(i +(j*j))%size;
            val=hashtable[check];
            j++;
            if(j>size) return -1;
        }
        return check;
    }
    public void display(){
        if(items==0)
            System.out.println("Hash table is empty!");
        else
        {
            System.out.println("Hash table contains :");
            for(int i=0;i<hashtable.length;i++)
            {
                if(hashtable[i]==NULL)
                    System.out.print("null  ");
                else
                    System.out.print(hashtable[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of the hash table:");
        int x=sc.nextInt();
        HashTableQP qp=new HashTableQP(x);
        qp.display();
        qp.insert(6);	qp.display();
        qp.insert(7);	qp.display();
        qp.insert(11);	qp.display();
        qp.insert(20);	qp.display();
        qp.insert(25);	qp.display();
        qp.insert(30);	qp.display();
    }
}
