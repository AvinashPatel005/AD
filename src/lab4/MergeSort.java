package lab4;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr,int l,int r){
        if(l<r){
            int m=(l+r) / 2;
            mergeSort(arr,0,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    public static void merge(int[] arr,int l,int m,int r){
        int[] left = new int[m-l+1];
        int[] right = new int[r-m];
        for (int i = 0; i < left.length; i++) {
            left[i]=arr[l+i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i]=arr[m+1+i];
        }
        int i=0;
        int j=0;
        int k=l;
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                k++;
                i++;
            }
            else{
                arr[k]=right[j];
                k++;
                j++;
            }
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,0,9,7,5};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
