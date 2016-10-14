package algorithm;

/**
 * Created by neng-zheng on 2016/6/27.
 * 动态规划求最长公共子序列
 * 设c[m][n]数组，m和n分别为两个数列x，y的长度，c[i][j]的值为，长度i的数列x和长度j的数列y的最长公共子序列的长度。
 * 即c[m][n]为最终长度，并且可得下式：
 * if x[m-1] == y[n-1] { c[m][n] = c[m-1][n-1] + 1 }
 * if x[m-1] != y[n-1] { c[m][n] = Math.max (c[m][n-1], c[m-1][n] ) }
 *
 * 即可用动态规划求解长度，再根据c数组求解最终数列。
 */
public class DPLCSS {

    private int[][] c;
    public static void main(String[] arg){

        DPLCSS d=new DPLCSS();
        d.test();

    }

    public void test(){
        int[] x=new int[]{1,3,5,9,6};
        int[] y=new int[]{1,2,3,9,7,6};
        c=new int[x.length+1][y.length+1];  //c用于记录最长公共子序列的长度
        lcs(x,y);

    }

    public void lcs(int[] x, int[] y){
        int m=x.length;
        int n=y.length;
        for (int i=0;i<x.length+1;i++){
            c[i][0]=0;
        }
        for (int j=0;j<y.length+1;j++){
            c[0][j]=0;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (x[i-1] == y[j-1]){               //相等则长度加1
                    c[i][j]=c[i-1][j-1]+1;
                    System.out.print(x[i-1]);
                }else {
                    c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
                }
            }
        }

    }

}
