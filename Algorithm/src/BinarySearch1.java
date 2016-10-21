/**
 * Created by neng-zheng on 2016/6/27.
 * 非递归实现二分查找法，找不到返回-1
 */
public class BinarySearch1 {

    public static void main(String[] arg){

        BinarySearch1 b=new BinarySearch1();
        b.test();
    }

    public int binarySearch(int x, int[] a, int low, int hight){
        while (low <= hight) {
            int mid = (low + hight) / 2;
            if (x == a[mid]) return mid;
            if (x > a[mid]) low = mid + 1;
            if (x < a[mid]) hight = mid - 1;
        }
        return -1;
    }

    public void test(){
        int[] a=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int x=11;
        int low=0;
        int hight=14;
        System.out.println(binarySearch(x,a,low,hight));
    }
}
