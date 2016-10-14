package algorithm;

import java.util.Arrays;

/**
 * Created by neng-zheng on 2016/6/27.
 * 归并排序法，复杂度O（nlogn）
 * 归并实质就是将两个有序数列归并为一个有序数列。
 */
public class MergeSort {
    public static void main(String[] arg){

        MergeSort m=new MergeSort();
        m.test();
    }

    public void test(){
        int[] a=new int[]{9,1,5,7,21,5,6,3,11};
        System.out.println(Arrays.toString(a));
        int low=0;
        int hight=a.length-1;
        mergeSort(a,low,hight);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int[] a, int low, int hight){
        if (low < hight){
            int mid=(low + hight) / 2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,hight);
            int[] b=new int[a.length];
            merge(a,b,low,mid,hight);
            copy(a,b,low,hight);
        }
    }

    public void merge(int[] a, int[] b, int low, int mid, int hight){
        int i=low;
        int j=mid+1;
        int k=low;

        while (i<=mid && j<=hight){
            if (a[i]<=a[j]){
                b[k]=a[i];
                k++;
                i++;
            }
            if (a[i]>a[j]){
                b[k]=a[j];
                k++;
                j++;
            }
        }
        if (i>mid){
            for (int n=j;n<=hight;n++){
                b[k]=a[n];
                k++;
            }
        }
        if (i<=mid){
            for (int n=i;n<=mid;n++){
                b[k]=a[n];
                k++;
            }
        }
    }

    public void copy(int[] a, int[] b, int low, int hight){
        for (int i=low;i<=hight;i++){
            a[i]=b[i];
        }
    }
}
