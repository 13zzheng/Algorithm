package algorithm;

import java.util.Arrays;

/**
 * Created by neng-zheng on 2016/6/28.
 * 回溯法求集合所有排列（奇偶相间）
 */
public class Backtrack1 {

    private int[] s;
    private int n;
    private int[] x;
    public static void main(String[] arg){

        Backtrack1 b=new Backtrack1();
        b.test();

    }

    public void test(){
        n=7;
        s=new int[]{1,2,3,4,5,6,7};
        x=new int[]{1,2,3,4,5,6,7};
        backtrack(0);
    }
    public void backtrack(int t){
        if (t>=n){
            System.out.println(Arrays.toString(x));
        }else {
            for (int i=t;i<n;i++){
                swap(t,i);
//                backtrack(t+1);
                if (legal(t,i)) backtrack(t+1);
                swap(t,i);
            }
        }
    }

    /**
     * 交换位置
     * @param t
     * @param i
     */
    public void swap(int t,int i){
        int temp=x[t];
        x[t]=x[i];
        x[i]=temp;
    }

    /**
     * 判断奇偶是否一致
     * @param t
     * @param i
     * @return
     */
    public boolean legal(int t,int i){
        boolean b=true;
        if (t != i && ((i-t)%2 == 1)){
            b=false;
        }
        return  b;

    }
}
