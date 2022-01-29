package Acwing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class AA {
    public static void main(String[] args) {
        int[] arr = new int[105];
        //在1-100以内，找到二者和不属于  1到14的平方  的set，将这个两个直接加到list中。
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 2; i <= 14; i++){
            list.add(i*i);
        }
        for(int i = 2; i <= 100; i++){
            for(int x:set){
                if(list.contains(x+i)){
                   set.remove(x);
                   break;
                }
            }
            set.add(i);
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}
