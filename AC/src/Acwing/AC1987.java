package Acwing;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class AC1987 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> map = new TreeMap<>((Comparator.comparingInt(o -> o)));
        int n = sc.nextInt();
        int now = 0;
        while(n-- != 0){
            int x = sc.nextInt();
            if(sc.next().equals("R")){
                map.put(now,map.getOrDefault(now,0)+1);
                now += x;
                map.put(now,map.getOrDefault(now,0)-1);
            }else{
                map.put(now,map.getOrDefault(now,0)-1);
                now -= x;
                map.put(now,map.getOrDefault(now,0)+1);
            }

        }
        int ans = 0,sum = 0,pre = 0;
        for(int x:map.keySet()){
            if(sum >= 2){
                ans+= x-pre;
            }
            sum +=map.get(x);
            pre = x;
        }
        System.out.println(ans);
    }
}
