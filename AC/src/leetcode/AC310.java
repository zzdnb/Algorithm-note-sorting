package leetcode;

import java.util.*;

public class AC310 {
    public static void main(String[] args) {
        new AC310().findMinHeightTrees(4,new int[][]{{1,0},{1,2},{1,3}});
    }
    int N = 2 * (int)1e4 + 10, M = N * 2;
    int[] h = new int[N], e = new int[M],ne = new int[M];
    int idx = 0;
    void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    List<Integer> ans = new ArrayList<>();

    PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2)->{
        return o1[0] - o2[0];
    });
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return ans;
        }
        Arrays.fill(h,-1);
        for(int[]x: edges){
            add(x[0],x[1]);
            add(x[1],x[0]);
        }
        for(int i = 0; i < n; i++){
            bfs(i);
        }
        int[] tmp = q.poll();
        ans.add(tmp[1]);
        while(q.size()!=0){
            int[] t = q.poll();
            if(tmp[0] == t[0]){
                ans.add(t[1]);
            }else{
                break;
            }
        }
        return ans;
    }
    void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        int len = 0;

        loop: while(queue.size()!=0){
            int sz = queue.size();
            len++;
            for(int i = 0; i < sz; i++){
                int t = queue.poll();
                System.out.println(t);
                if(h[t] == -1){
                    break loop;
                }
                for(int j = h[t]; j != -1; j = ne[j]){
                    queue.offer(e[j]);
                }
            }
        }
        q.offer(new int[]{x,len-1});
    }
}
