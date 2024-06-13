package lab4;

import java.util.Arrays;

public class QuickSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort(int[] arr,int l,int r){
        if(l<r){
            int p = partition(arr,l,r);
            System.out.println(Arrays.toString(arr));
            sort(arr,l,p-1);
            sort(arr,p+1,r);
        }
    }
    public static int partition(int[] arr,int l,int r){
        int p=l;
        int pivot = arr[r];
        int q=r-1;
        while(p<=q){
            while(arr[p]<pivot){
                p++;
            }
            while(arr[q]>pivot){
                q--;
            }
            if(p<q){
                swap(arr,p,q);
            }
            else {
                swap(arr,p,r);
            }
        }
        return p;
    }
    public static void main(String[] args) {
        int[] arr = { 10, 2,7, 8, 9, 1, 5 };
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
