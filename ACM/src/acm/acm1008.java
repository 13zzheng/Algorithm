package acm;

import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/5/14.
 */
public class acm1008 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            if (n==0) break;
            int current=0;
            int sumtime=0;
            for (int i=0;i<n;i++){
                int f=scanner.nextInt();
                int a=f-current;
                current=f;
                if (a>=0){
                    sumtime+=a*6+5;
                }else {
                    sumtime+=-a*4+5;
                }
            }
            System.out.println(sumtime);
        }
    }
}
