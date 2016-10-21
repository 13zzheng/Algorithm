/**
 * Created by neng-zheng on 2016/6/28.
 * 贪心算法生成一个边的最大权值最小的生成树
 */
public class Greedy0 {
    private int[] closest;
    private int[] lowcost;
    private boolean[] s;
    public static void main(String[] arg){

        Greedy0 g=new Greedy0();
        g.test();

    }

    public void test(){
        closest=new int[7];
        lowcost=new int[7];
        s=new boolean[7];
        int[][] c=new int[7][7];
        int max=Integer.MAX_VALUE;
        c[1][1]=0;
        c[1][2]=6;
        c[1][3]=1;
        c[1][4]=5;
        c[1][5]=max;
        c[1][6]=max;

        c[2][1]=6;
        c[2][2]=0;
        c[2][3]=5;
        c[2][5]=3;
        c[2][4]=max;
        c[2][6]=max;

        c[3][1]=1;
        c[3][2]=5;
        c[3][3]=0;
        c[3][4]=5;
        c[3][5]=6;
        c[3][6]=4;

        c[4][1]=5;
        c[4][2]=max;
        c[4][3]=5;
        c[4][4]=0;
        c[4][5]=max;
        c[4][6]=2;

        c[5][1]=max;
        c[5][2]=3;
        c[5][3]=6;
        c[5][4]=max;
        c[5][5]=0;
        c[5][6]=6;

        c[6][1]=max;
        c[6][2]=max;
        c[6][3]=4;
        c[6][4]=2;
        c[6][5]=6;
        c[6][6]=0;
        greedy(6,c);

    }

    public void greedy(int n,int [][] c){
        s[1]=true;
        for (int i=2;i<=n;i++){
            s[i]=false;
        }
        int j = 1;
        int m = 1;
        for (int i=0;i<n;i++) {
            int min=Integer.MAX_VALUE;
            for (int k = 2; k <= n; k++) {
                if (c[j][k] < min && !s[k]) {
                    min = c[j][k];
                    m = k;
                }

            }
            s[m] = true;
            j=m;
            System.out.println(j);
        }
    }
}
