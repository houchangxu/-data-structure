package dataStructure;

import java.util.Arrays;

//快速排序  最坏复杂度O(N²)，平均是O(nlogn) 稳定的算法 空间复杂度为O(1)
public class QuickSort {
    public static void main(String[] args) {
        int [] sorts = {1,5,6,2,3,51,32,55,71,23,45};
        System.out.println(Arrays.toString(sorts));
    }

    public static void quickSort(int []a,int start,int end ){
        if(start>=end){
            return;
        }
        int index = a[start];
        int i = start;
        int j = end;
        while(i<j){
            //先看右边，依次往左递减
            while (index<=a[j]&&i<j) {
                j--;
            }
            if(i<j){
                a[i] = a[j];
            }
            //再看左边，依次往右递增
            while (index>=a[i]&&i<j) {
                i++;
            }
            if(i<j){
                a[j] = a[i];
            }
        }
        a[i] = index;//i、j相遇，将index赋值给a[i]

        quickSort(a,start,i-1);
        quickSort(a,i+1,end);
    }
}
