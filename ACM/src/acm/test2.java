package acm;

/**
 * Created by neng-zheng on 2016/3/31.
 */
public class test2 {

    public static void main(String[] args) {
        int x=5;//啤酒盖数
        int y=5;//啤酒瓶数
        int sum=5;//总的啤酒数
        while (x/4!=0 || y/2!=0){
            //n为啤酒盖换来的啤酒数，m为啤酒瓶换来的啤酒数
            int n=x/4;
            int m=y/2;
            int s=n+m;
            //剩下的啤酒盖和啤酒瓶数
            x=x%4;
            y=y%2;
            //加上刚刚换来的瓶酒数
            x+=s;
            y+=s;
            sum+=s;
        }
        System.out.println(sum);
        System.out.println("啤酒盖数："+x+" 空啤酒瓶数："+y);
    }
}

