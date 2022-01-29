package Acwing;

import java.util.*;

public class N {
    static int max = Integer.MAX_VALUE;
    static int n,m;
    static int N = 100009;
    static  int [] dist = new int[N];
    static boolean[] st = new boolean[N];
    static Map<Integer, Map<Integer,Integer>> map  = new HashMap<>();
    public static void main(String[] args) {

    }
    static int spfa(){
        Arrays.fill(dist,max);
        //st[i]  = false;
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        st[1] = true;
        while (!queue.isEmpty()){
            int a = queue.poll();
            st[a] = false;
            Map<Integer,Integer> mm = map.get(a);
            if(mm==null){
                continue;
            }
            for(int b :mm.keySet()){
                if(dist[b]>dist[a]+mm.get(b)){
                    dist[b] = dist[a] + mm.get(b);
                    if(!st[b]){
                        queue.offer(b);
                        st[b] = true;
                    }
                }
            }
        }
        if(dist[n]==max){
            return -1;
        }
        return dist[n];
    }

}
