package acm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class acm1004 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String color="";
        while(sc.hasNext()){
            int n=sc.nextInt();
            if (n==0){
                break;
            }
            int max=0;
            Map<String,Integer> map=new HashMap<String,Integer>();
            for (int i=1;i<=n;i++){
                String str=sc.next();
                if (map.containsKey(str)){
                    map.put(str,map.get(str)+1);
                }else {
                    map.put(str,1);
                }
            }
            for (String key : map.keySet()){
                if  (max < map.get(key)){
                    max=map.get(key);
                    color=key;
                }
            }
            System.out.println(color);
        }

    }
}
