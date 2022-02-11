package zuoshen;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class D {
    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(1, "2");
        map1.put(2, "2");
        map1.put(3, "1");
        for (int x : map1.keySet()) {
            System.out.println(x + " " + map1.get(x));
        }
        System.out.println("===========");
        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "2");
        map2.put(3, "1");
        map2.put(2, "2");
        for (int x : map2.keySet()) {
            System.out.println(x + " " + map2.get(x));
        }
        System.out.println("===========");
        TreeMap<Integer, String> map3 = new TreeMap<>();
        map3.put(1, "2");
        map3.put(3, "1");
        map3.put(2, "2");
        for (int x : map3.keySet()) {
            System.out.println(x + " " + map3.get(x));
        }
        System.out.println(map3.firstKey());
        System.out.println(map3.lastKey());
        System.out.println(map3.floorKey(2));
        System.out.println(map3.ceilingKey(2));
    }
}
