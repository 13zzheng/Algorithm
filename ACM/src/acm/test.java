package acm;

import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/3/27.
 */
public class test {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int b = sc.nextInt();
            int w = sc.nextInt();
            int sum=b+w;
            int p=0;
            int q=1;
            String w0="000000000000";
            String b0="111111111111";
            String re="";
            re=w0.substring(0,w)+b0.substring(0,b);
            int offset;
            while ((offset =re.indexOf("01",0))!=-1){
                int start=offset;
                int sum0=0;
                String temp1=re.replaceAll("01","");
                re=re.substring(0,start)+"10"+re.substring(start+2,sum);
                sum0=start-re.substring(0,start).replaceAll("0","").length();
                String temp2=w0.substring(0,sum0)+b0.substring(0,start-sum0);
                re=temp2+re.substring(start,sum);
                p+=(sum-temp1.length())/2;
                q++;
            }
            int max=1;
            for (int i=1;i<=Math.min(p,q);i++){
                if (p%i==0 && q%i==0){
                    max=i;
                }
            }
            System.out.println(p/max+"/"+q/max);
        }
    }
}
