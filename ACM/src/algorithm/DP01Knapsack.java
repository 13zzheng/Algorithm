package algorithm;

import java.util.Arrays;

/**
 * Created by neng-zheng on 2016/6/27.
 * 动态规划求解01背包问题
 */
public class DP01Knapsack {
    private int[][] m;
    private int[] x;
    public static void main(String[] arg){

        DP01Knapsack d=new DP01Knapsack();
        d.test();
    }
    public void test(){
        int[] w=new int[]{3,4,5,5,1};  //重量
        int[] v=new int[]{2,4,3,5,4};  //价值
        int b=7;                       //包的容量
        x=new int[w.length];
        m=new int[w.length][8];        //m的值表示最大价值，第一个下标表示前几个物品，第二个下标表示
        knapsack(w,v,b);
        System.out.println(m[w.length-1][7]);
        traceback(w,b);
        System.out.println(Arrays.toString(x));
    }

    //最优值
    public void knapsack(int[] w, int[] v,int b){
        int n=w.length;
        for (int i=0;i<b;i++){
            m[0][i]=0;
        }
        for (int i=w[0];i<=b;i++){
            m[0][i]=v[0];
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<=b;j++){
                if (j<w[i]){
                    m[i][j]=m[i-1][j];
                }
                if (j>=w[i]){
                    if (m[i-1][j-w[i]]+v[i]>m[i-1][j]){
                        m[i][j]=m[i-1][j-w[i]]+v[i];
                    }else {
                        m[i][j]=m[i-1][j];
                    }
                }
            }
        }
    }


    public void traceback(int[] w,int b){
        int n=w.length-1;
        for (int i=n;i>=1;i--){
            if (b>=0) {
                if (m[i][b] == m[i - 1][b]) x[i] = 0;
                else {
                    x[i] = 1;
                    b -= w[i];
                }
            }
        }
        x[0]=(m[0][b]>0)? 1:0;

    }
}
