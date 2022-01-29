package Acwing;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.TreeMap;

public class AC1969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(map.get(x)==null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(x,list);
            }else{
                map.get(x).add(i);
            }
        }
        int ans = -1;
        for(int x:map.keySet()){
            int pre = map.get(x).get(0);
            for(int i = 1; i < map.get(x).size();i++){
                if(Math.abs(map.get(x).get(i)-pre)<=k){
                    ans = x;
                    break;
                }
                pre = map.get(x).get(i);
            }
        }
        System.out.println(ans);
    }
}
