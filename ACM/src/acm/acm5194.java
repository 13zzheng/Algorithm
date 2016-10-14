package acm;

import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/3/30.
 */
public class acm5194 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int b=sc.nextInt();
            int w=sc.nextInt();
            int sum=b+w;
            int q=1;
            int p=0;
            int [] s=new int[sum];
            for (int i=0;i<sum;i++){
                if (i<b){
                    s[i]=1;
                }else {
                    s[i]=0;
                }
            }
            boolean is=true;
            while (is){
                q++;
                int mark=0;
                int sum1=0;
                is=false;
                for (int i=0;i<sum-1;i++){
                    if (s[i]==1 && s[i+1]==0){
                        int temp=s[i];
                        s[i]=s[i+1];
                        s[i+1]=temp;
                        mark=i;
                        break;
                    }
                }
                for (int i=0;i<mark;i++){
                    if (s[i]==1){
                        sum1++;
                    }
                }
                for (int i=0;i<mark;i++){
                    if (sum1>0){
                        s[i]=1;
                        sum1--;
                    }else{
                        s[i]=0;
                    }
                }
                for (int i=1;i<=b;i++){
                    if (s[sum-i]!=1){
                        is=true;
                    }
                }
                String re="";
                for (int i=0;i<sum;i++){
                    re+=s[i];
                }
                int offset=0;
                while ((offset =re.indexOf("01",offset))!=-1){
                    offset+=2;
                    p++;
                }
            }
            int max=1;
            for (int i=1;i<Math.min(p,q);i++){
                if (p%i==0 && q%i==0){
                    max=i;
                }
            }
            System.out.println(p/max+"/"+q/max);

        }
    }
}
