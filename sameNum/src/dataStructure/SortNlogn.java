package dataStructure;

import java.util.Arrays;
import java.util.logging.Logger;

public class SortNlogn {


    public static void main(String[] args) {
        int [] sorts = {1,5,6,2,3,51,32,55,71,23,45};
        merge_sort(sorts,0,sorts.length-1);
        System.out.println(Arrays.toString(sorts));

    }
//归并排序  分治算法  时间复杂度稳定为O(nlogn)  但是不是稳定的排序算法
    public static void merge_sort(int[] a,int b,int c){
        System.out.println(Arrays.toString(a)+"  " +b +"   "+c);
        if(b<c){
            int q = (b+c)/2;
            merge_sort(a,b,q);
            merge_sort(a,q+1,c);
            mergesort(a,b,q,c);
        }

    }

    public static void mergesort(int[]a ,int left,int mid,int right){
        int temp [] = new int[a.length];
        int i=left;
        int j=mid+1;
        int k = left;
        while(i<=mid && j<=right){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        while(i<=mid) temp[k++]=a[i++];//????????????δ?????????????????????????????????
        while(j<=right) temp[k++]=a[j++];//???

        for(int ks=left;ks<=right;ks++){
            a[ks] = temp[ks];
        }
    }
}
