package lab2;

import java.util.Scanner;

public class HashTableLP {
    int[] hashtable;
    int size;
    int items;
    static int NULL = Integer.MIN_VALUE;
    public HashTableLP(int num){
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
            if(x!=i) items++;
            hashtable[x]=num;
        }
    }
    public int collision(int i){
        int val = hashtable[i];
        int pos =i;
        while (val!=NULL){
            pos=(pos+1)%size;
            val=hashtable[pos];
            if(pos==i) break;
        }
        return pos;
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
        HashTableLP lp=new HashTableLP(x);
        lp.display();
        lp.insert(6);
        lp.display();
        lp.insert(-7);
        lp.display();
        lp.insert(11);
        lp.display();
        lp.insert(20);
        lp.display();
        lp.insert(25);
        lp.display();
        lp.insert(30);
        lp.display();
    }
}
