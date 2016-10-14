package acm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/5/14.
 */
class Fat implements Comparable<Fat>{
    public int j,f;
    public double ave;
    @Override
    public int compareTo(Fat o) {
        if (this.ave<o.ave) return 1;
        else if (this.ave==o.ave) return 0;
        else return -1;

    }
}
public class acm1009 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            if (m==-1 && n==-1) break;
            double sum=0;
            Fat[] fs=new Fat[n];
            for (int i=0;i<n;i++){
                fs[i]=new Fat();
                fs[i].j=scanner.nextInt();
                fs[i].f=scanner.nextInt();
                fs[i].ave=fs[i].j*1.0/fs[i].f;
            }
            Arrays.sort(fs);
            for (int i=0;i<n;i++){
                if (m<fs[i].f){
                    sum+=m*fs[i].ave;
                    break;
                } else {
                    sum+=fs[i].j;
                    m-=fs[i].f;
                }
            }
//            DecimalFormat df=new DecimalFormat("0.000");
            System.out.printf("%.3f", sum);
            System.out.println();
        }
    }
}
