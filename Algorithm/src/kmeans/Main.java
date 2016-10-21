package kmeans;

/**
 * Created by neng-zheng on 2016/1/4.
 */
public class Main {

    public static void main(String[] arg0) {
        //创建K点
        K k1=new K();
        K k2=new K();
        K k3=new K();
        Caculator caculator=new Caculator();
        //添加簇到计算器里
        caculator.addK(k1);
        caculator.addK(k2);
        caculator.addK(k3);
        //获取鸢尾数据
        caculator.getData();
        caculator.caculate();

    }
}
