package algorithm;

import java.util.Arrays;

/**
 * Created by neng-zheng on 2016/6/28.
 * 回溯法之求所有子集集合
 *
 * 子集集合其实是由原集合每个元素的两种状态决定，1表示属于子集集合，0表示不数据子集集合。
 * 所以用一个数组来记录0,1状态。遍历所有情况就可以得出所有的子集集合了。
 */
public class Backtrack0 {
    private int[] s;
    private int n;
    private int[] x;
    public static void main(String[] arg){

        Backtrack0 b=new Backtrack0();
        b.test();

    }

    public void test(){
        n=7;
        s=new int[]{1,2,3,4,5,6,7};
        x=new int[7];
        backtack(0);
    }

    public void backtack(int t){
        if (t>=n){
            System.out.println(Arrays.toString(x));
        }else {
            for (int i=0;i<=1;i++){
                x[t]=i;
                backtack(t+1);
            }
        }
    }
}
