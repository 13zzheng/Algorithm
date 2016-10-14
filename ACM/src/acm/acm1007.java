package acm;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/4/25.
 */
public class acm1007 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            if (n==0) break;
            double x1=0,y1=0,x2=0,y2=0;
            double min=-1;
            DecimalFormat df=new DecimalFormat("0.00");
            for (int i=0;i<n;i++){
                if (i==0) {
                    x1 = Double.valueOf(scanner.next());
                    y1 = Double.valueOf(scanner.next());
                }else  {
                    x2 = Double.valueOf(scanner.next());
                    y2 = Double.valueOf(scanner.next());
                    double temp;
                    temp=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
                    if (i==1){
                        min=temp;
                    }
                    if (temp<min){
                        min=temp;
                    }
                    x1=x2;
                    y1=y2;
                }
            }
            System.out.println(df.format(Math.sqrt(min)/2));
        }
    }
}
