package luogu;

import java.util.TreeSet;

public class B {
    public static void main(String[] args) {
        TreeSet<Float> set = new TreeSet<Float>((o2,o1)-> (int) Math.ceil(o1-o2));
        set.add((float) 1.02);
        set.add((float) 2.02);
        set.add((float) 0.02);
        for(float x:set){
            System.out.println(x);
        }
    }

}
