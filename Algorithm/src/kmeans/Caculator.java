package kmeans;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by neng-zheng on 2016/1/4.
 */
public class Caculator {
    private List<Bird> birds;
    private final String PATH="/data.txt";
    private List<K> ks;


    //构造方法
    public Caculator(){
        birds=new ArrayList<Bird>();
        ks=new ArrayList<K>();
    }
    //添加簇
    public void addK(K k){
        ks.add(k);
    }
    //获得簇的初始平均值
    public void initK(){
        Random ra=new Random();
        for (int i=0;i<ks.size();i++){
            int s=ra.nextInt(birds.size());
            ks.get(i).setX(birds.get(s).getX());
            ks.get(i).setY(birds.get(s).getY());
            ks.get(i).setZ(birds.get(s).getZ());
            ks.get(i).setM(birds.get(s).getM());
        }
    }
    //从文件获取鸢尾数据
    public void getData() {
        File file = new File(PATH);
        String temp=null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            temp = bufferedReader.readLine();
            while (temp != null) {
                input(temp);
                temp = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //将鸢尾数据放进鸢尾对象里
    private void input(String temp){
        String[] data=null;
        if (!temp.equals("")) {
            data = temp.split(",");
            Bird bird = new Bird();
            bird.setX(Float.valueOf(data[0]));
            bird.setY(Float.valueOf(data[1]));
            bird.setZ(Float.valueOf(data[2]));
            bird.setM(Float.valueOf(data[3]));
            bird.setBirdClass(data[4]);
            birds.add(bird);
        }
    }
    //Kmeans计算过程
    public void caculate(){
        float distance1;
        float distance2;
        float distance3;
        float distance;
        float e1=-1;
        float e2=-1;
        float e3=-1;
        int n=0;
        //获得簇的初始平均值
        initK();
        //当准则函数不变时退出计算
        while (!(ks.get(0).getE()==e1 && ks.get(1).getE()==e2 && ks.get(2).getE()==e3)) {
            n++;
            //清除数据
            ks.get(0).clean();
            ks.get(1).clean();
            ks.get(2).clean();
            for (int i = 0; i < birds.size(); i++) {
                //求到三个点的距离
                distance1 = (float) (Math.pow(birds.get(i).getX() - ks.get(0).getX(), 2) + Math.pow(birds.get(i).getY() - ks.get(0).getY(), 2) + Math.pow(birds.get(i).getZ() - ks.get(0).getZ(), 2) + Math.pow(birds.get(i).getM() - ks.get(0).getM(), 2));
                distance2 = (float) (Math.pow(birds.get(i).getX() - ks.get(1).getX(), 2) + Math.pow(birds.get(i).getY() - ks.get(1).getY(), 2) + Math.pow(birds.get(i).getZ() - ks.get(1).getZ(), 2) + Math.pow(birds.get(i).getM() - ks.get(1).getM(), 2));
                distance3 = (float) (Math.pow(birds.get(i).getX() - ks.get(2).getX(), 2) + Math.pow(birds.get(i).getY() - ks.get(2).getY(), 2) + Math.pow(birds.get(i).getZ() - ks.get(2).getZ(), 2) + Math.pow(birds.get(i).getM() - ks.get(2).getM(), 2));
                if (distance1 <= distance2) {
                    distance = distance1;
                } else {
                    distance = distance2;
                }
                if (distance <= distance3) {
                    if (distance == distance1) {
                        ks.get(0).add(birds.get(i));
                    } else {
                        ks.get(1).add(birds.get(i));
                    }
                } else {
                    distance = distance3;
                    ks.get(2).add(birds.get(i));
                }
            }
            //计算准则函数值
            ks.get(0).caculateE();
            ks.get(1).caculateE();
            ks.get(2).caculateE();
            e1=ks.get(0).getE();
            e2=ks.get(1).getE();
            e3=ks.get(2).getE();
            //计算新的簇平均值和新的准则函数值
            resetK(ks.get(0));
            resetK(ks.get(1));
            resetK(ks.get(2));
            ks.get(0).caculateE();
            ks.get(1).caculateE();
            ks.get(2).caculateE();
//            System.out.println(ks.get(0).getE());
//            System.out.println(ks.get(1).getE());
//            System.out.println(ks.get(2).getE());
        }
        System.out.println("time:" + n);
        //打印出每个簇的数据
        ks.get(0).print();
        System.out.println();
        System.out.println();
        ks.get(1).print();
        System.out.println();
        System.out.println();
        ks.get(2).print();
    }
    //改变簇的平均值
    public void resetK(K k){
        float sumX=0;
        float sumY=0;
        float sumZ=0;
        float sumM=0;
        int size=k.getBirds().size();
        for (int i=0;i<size;i++){
            sumX+=k.getBirds().get(i).getX();
            sumY+=k.getBirds().get(i).getY();
            sumZ+=k.getBirds().get(i).getZ();
            sumM+=k.getBirds().get(i).getM();
        }
        k.setX(sumX / size);
        k.setY(sumY / size);
        k.setZ(sumZ / size);
        k.setM(sumM / size);
    }
}
