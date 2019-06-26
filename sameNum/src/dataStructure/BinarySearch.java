package dataStructure;
public class BinarySearch {

    //二分查找是一种时间复杂度为 O(logN)的算法，但是有一定的局限性，比如底层要求必须是有序且连续的数组。
    // 数据量太小情况下不适用二分查找，顺序遍历更有优势；
    // 数据量过大的情况下，对内存的条件比较苛刻，比如1GB的数据，如果内存都是零散的，则不能适用二分查找。

    //递归方式，优化方案，计算机位运算比算数运算速度快。
    public static int binay(int a[] ,int start,int end,int value){
        if(end<start){
            return  -1;
        }
        int mid = end +((end-start)>>1);
        if(value == a[mid]){
            return mid;
        }else if(value>a[mid]){
            return binay(a,mid+1,end,value);
        }else {
            return binay(a,start,mid-1,value);
        }
    }

    //循环方式
    public static int binary(int a[],int low,int high,int value){
        if(high<low){
            return -1;
        }//相比于位运算，算数运算略慢
        while(high>=low ){
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
