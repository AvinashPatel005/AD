package lab3;

import java.util.Arrays;

public class FractionalKnapsack {
    static class Item implements Comparable<Item>{
        int weight;
        int cost;
        double ratio;
        Item(int w,int c){
            weight=w;
            cost=c;
            ratio=(double)c/w;
        }
        @Override
        public int compareTo(Item i){
            return (int)(i.ratio-this.ratio);
        }
    }

    public static void main(String[] args) {
        int[] wt = { 10, 40, 20, 30 };
        int[] cost = { 60, 40, 90, 120 };
        int n = wt.length;
        int capacity = 50;
        Item[] itemList = new Item[n];
        for (int i = 0; i < n; i++)
            itemList[i] = new Item(wt[i], cost[i]);
        Arrays.sort(itemList);
        double costAccumulated = 0;
        int i=0;
        while(capacity>0){
            if(capacity-itemList[i].weight>=0){
                capacity-=itemList[i].weight;
                costAccumulated+=itemList[i].cost;            }
            else{
                costAccumulated += (itemList[i].ratio * capacity);
                break;
            }
            i++;
        }
        System.out.println(costAccumulated);
    }
}
