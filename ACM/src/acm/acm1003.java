package acm;

import java.util.Scanner;


public class acm1003 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for (int i=1;i<=t;i++){
            int n=sc.nextInt();
            int temp=1;
            int start=1;
            int end=1;
            int max=-1001;
            int sum=0;
            for (int j=1;j<=n;j++){
                sum+=sc.nextInt();
                if (sum>max){
                    max=sum;
                    start=temp;
                    end=j;
                }
                if (sum<0){
                    sum=0;
                    temp=j+1;
                }
            }
            System.out.println("Case "+i+":");
            System.out.println(max+" "+start+" "+end);
            if (i!=t){
                System.out.println();
            }
        }
    }

}
