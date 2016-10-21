package kmeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neng-zheng on 2016/1/4.
 */
public class K {
    private List<Bird> birds;
    private float x=0;
    private float y=0;
    private float z=0;
    private float m=0;
    private float e=0;
    private float exe=-1;

    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }

    public float getE() {
        return e;
    }

    public void setE(float e) {
        this.e = e;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }

    //构造函数
    public K(){
        birds=new ArrayList<Bird>();
    }
    //clone
    public K clone(){
        K k=new K();
        k.setX(x);
        k.setY(y);
        k.setZ(z);
        k.setM(m);
        return k;
    }
    //equals
    public boolean equals(K k){
        boolean b=false;
        if (k.getX()==x && k.getY()==y && k.getZ()==z && k.getM()==m){
            b=true;
            return b;
        }
        return b;

    }
    //计算准则函数值E
    public void caculateE(){
        e=0;
        for (int i=0;i<birds.size();i++){
            e+=Math.pow(birds.get(i).getX()-x,2)+Math.pow(birds.get(i).getY()-y,2)+Math.pow(birds.get(i).getZ()-z,2)+Math.pow(birds.get(i).getM()-m,2);
        }
    }

    //打印数据
    public void print(){
        for (int i=0;i<birds.size();i++){
            System.out.println(birds.get(i).getX()+","+birds.get(i).getY()+","+birds.get(i).getZ()+","+birds.get(i).getM()+","+birds.get(i).getBirdClass());
        }
    }
    //添加数据
    public void add(Bird bird){
        birds.add(bird);
    }

    //清空数据
    public void clean(){
        birds.clear();
    }
}
