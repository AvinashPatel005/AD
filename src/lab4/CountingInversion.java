package lab4;

import java.util.Arrays;

public class CountingInversion {
    public static int mergeSort(int[] arr,int l,int r){
        int count = 0;
        if(l<r){
            int m=(l+(r-1)) / 2;
            count += mergeSort(arr,0,m);
            count += mergeSort(arr,m+1,r);
            count += merge(arr,l,m,r);
        }
        return count;
    }
    public static int merge(int[] arr,int l,int m,int r){
        int[] left = new int[m-l+1];
        int[] right = new int[r-m];
        int c=0;
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
                c+=m+1-(l+i);
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
        return c;
    }
    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        int c = mergeSort(arr,0,arr.length-1);
        System.out.println(c);
    }
}
