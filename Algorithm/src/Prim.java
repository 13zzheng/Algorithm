/**
 * Created by neng-zheng on 2016/6/28.
 * 贪心算法之最小生成树 Prim
 */
public class Prim {
    private int[] closest;
    private int[] lowcost;
    private boolean[] s;
    public static void main(String[] arg){

        Prim p=new Prim();
        p.test();

    }

    public void test(){
        closest=new int[8];
        lowcost=new int[8];
        s=new boolean[8];
        int[][] c=new int[8][8];
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
        c[2][5]=max;
        c[2][4]=max;
        c[2][6]=max;

        c[3][1]=1;
        c[3][2]=5;
        c[3][3]=0;
        c[3][4]=5;
        c[3][5]=5;
        c[3][6]=4;

        c[4][1]=5;
        c[4][2]=max;
        c[4][3]=5;
        c[4][4]=0;
        c[4][5]=max;
        c[4][6]=2;

        c[5][1]=max;
        c[5][2]=max;
        c[5][3]=5;
        c[5][4]=max;
        c[5][5]=0;
        c[5][6]=6;

        c[6][1]=max;
        c[6][2]=max;
        c[6][3]=4;
        c[6][4]=2;
        c[6][5]=6;
        c[6][6]=0;


        c[7][2]=6;
        c[2][7]=6;
        c[7][5]=5;
        c[5][7]=5;
        c[1][7]=max;
        c[3][7]=max;
        c[4][7]=max;
        c[6][7]=max;
        c[7][7]=0;
        c[7][1]=max;
        c[7][3]=max;
        c[7][4]=max;
        c[7][6]=max;
        prim(7,c);


    }
    public void prim(int n,int[][] c){
        s[1]=true;
        for (int i=2;i<=n;i++){
            lowcost[i]=c[1][i];
            closest[i]=1;
            s[i]=false;
        }

        for (int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            int j=1;
            for (int k=2;k<=n;k++){
                if (lowcost[k]<min && !s[k]){
                    min=lowcost[k];
                    j=k;
                }
            }

            System.out.println(closest[j]+" "+j);
            s[j]=true;
            for (int k=2;k<=n;k++){
                if (c[j][k]<lowcost[k] && !s[k]){
                    lowcost[k]=c[j][k];
                    closest[k]=j;
                }
            }
        }
    }
}
