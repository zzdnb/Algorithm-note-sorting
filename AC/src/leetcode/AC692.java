package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class AC692 {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},3));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        TreeMap<String,Integer> map = new TreeMap<>();
        for(String x:words){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(String x :map.keySet()){
            System.out.println(x +":"+map.get(x));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(String x:map.keySet()){
            list.add(map.get(x));
        }
        list.sort(((o1, o2) -> {
            return o2-o1;
        }));
        System.out.println(Arrays.toString(list.toArray()));
        int tmp = 0;
        List<String> list1 = new ArrayList<>();
        for(int x:list){

            for(String xx:map.keySet()){
                if(map.get(xx)==x){
                    tmp++;
                    map.put(xx,0);
                    list1.add(xx);
                }
                System.out.println(x);
                if(tmp == k){
                    return list1;
                }
            }
        }
        return list1;




    }
}
