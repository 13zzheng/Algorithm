package acm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by neng-zheng on 2016/3/30.
 */
public class acm4802 {
    public static void main(String[] args){
        Map<String,Float> map=new HashMap<String,Float>();
        map.put("A",4.0f);
        map.put("A-",3.7f);
        map.put("B+",3.3f);
        map.put("B",3.0f);
        map.put("B-",2.7f);
        map.put("C+",2.3f);
        map.put("C",2.0f);
        map.put("C-",1.7f);
        map.put("D",1.3f);
        map.put("D-",1.0f);
        map.put("F",0.0f);
        Scanner sc=new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("0.00");
        while (sc.hasNext()){
            boolean is=false;
            float cs=0.0f;
            float re=0.0f;
            int sumc=0;
            int n=sc.nextInt();
            for (int i=0;i<n;i++){
                int c=sc.nextInt();
                String ss=sc.next();
                if (map.containsKey(ss)){
                    is=true;
                    cs+=c*map.get(ss);
                    sumc+=c;
                }
            }
            if (!is){
                System.out.println(df.format(0));
            }else {
                re=cs/sumc;
                System.out.println(df.format(re));
            }
        }
    }
}
