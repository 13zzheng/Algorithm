package acm;

import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/4/27.
 */
public class acm2660 {

    static int n,k,maxw,sum;
    static int[][] vw;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        acm2660 main=new acm2660();
        while(scanner.hasNext()){
            n=0;
            k=0;
            sum=0;
            maxw=0;
            int cases=scanner.nextInt();
            for (int i=0;i<cases;i++){
                n=scanner.nextInt();
                k=scanner.nextInt();
                vw=new int[n][2];
                for (int j=0;j<n;j++){
                    vw[j][0]=scanner.nextInt();
                    vw[j][1]=scanner.nextInt();
                }
                maxw=scanner.nextInt();
                main.s(0,0,0,0);
                System.out.println(sum);
            }
        }
    }
    public void s(int v,int w,int z,int j){
        if(w > maxw || z > k)	return;//如果重量不符合或者合格个数超过限制--结束
        if(sum < v)	sum = v;//价值最高
        for(int i = j; i < n;i++)
            s(v + vw[i][0], w + vw[i][1], z + 1, i + 1);
    }
}
