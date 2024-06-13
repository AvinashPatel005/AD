package lab3;

import java.util.PriorityQueue;

public class Huffman {
    static class Node implements Comparable<Node>{
        char c;
        int freq;
        Node left;
        Node right;
        Node(char ch, int fr, Node l, Node r) {
            c = ch;
            freq = fr;
            left = l;
            right = r;
        }
        @Override
        public int compareTo(Node o) {
            return this.freq-o.freq;
        }
    }
    public static Node huffman(char[] ar,int[] fr){
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i=0;i<ar.length;i++){
            q.add(new Node(ar[i],fr[i],null,null));
        }
        while(q.size()>1){
            Node lf = q.poll();
            Node rf = q.poll();
            Node z = new Node('+',lf.freq + rf.freq,lf,rf);
            q.add(z);
        }
        return q.peek();
    }
    public static void print(Node root, String s) {
        if(root.c!='+'){
            System.out.println(root.c+" = "+s);
            return;
        }
        print(root.left,s+"0");
        print(root.right,s+"1");
    }
    public static void main(String[] args) {
        char[] ar = { 'A', 'B', 'C', 'D', 'E' };
        int[] fr = { 30, 25, 21, 14, 10 };
        print(huffman(ar,fr),"");
    }
}
