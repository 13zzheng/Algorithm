package algorithm;

import java.util.Arrays;

/**
 * Created by neng-zheng on 2016/6/27.
 * 快速排序法,平均情况下复杂度O（nlogn）
 */
public class QuickSort {
    public static void main(String[] arg){

        QuickSort q=new QuickSort();
        q.test();

    }

    public void test(){
        int[] a=new int[]{9,1,5,7,21,5,6,3,11};
        System.out.println(Arrays.toString(a));
        int low=0;
        int hight=a.length-1;
        quickSort(a,low,hight);
        System.out.println(Arrays.toString(a));
    }
    public void quickSort(int[] a,int low,int hight){
        if (low < hight){
            int key=partition(a,low,hight);
            quickSort(a,low,key-1);
            quickSort(a,key+1,hight);
        }

    }
    //划分
    public int partition(int[] a, int low, int hight){
        int i = low;
        int j = hight;
        int key =a [i];

        while(i<j){
            while (a[j] >= key && i<j){
                j--;
            }
            swap(a,i,j);
            while (a[i] < key && i<j){
                i++;
            }
            swap(a,i,j);
        }
        return j;

    }

    //交换
    public void swap(int[] a,int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
