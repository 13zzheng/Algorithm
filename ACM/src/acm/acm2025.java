package acm;

import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/4/13.
 */
public class acm2025 {
    public static void main(String []  args){
        Scanner scanner=new Scanner(System.in);
        int max;
        while(scanner.hasNext()){
            String a=scanner.next();
            char[] as=a.toCharArray();
            max =97;
            for (int i=0;i<as.length;i++){
                if (as[i]>max){
                    max=as[i];
                }
            }
            for (int i=0;i<as.length;i++){
                System.out.print(as[i]);
                if (as[i]==max){
                    System.out.print("(max)");
                }
            }
            System.out.println();
        }
    }
}
