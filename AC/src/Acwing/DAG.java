package Acwing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DAG {
    static int N = 10010;
    //d数组代表的是入度
    static int[] h = new int[N], e = new int[N],ne = new int[N],d = new int[N],top = new int[N];
    static int n,m,idx,cnt = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Arrays.fill(h,-1);
        while(m-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b);
            d[b]++;
        }
        if(topSort()){
            for(int i = 1; i <= n; i++){
                System.out.print(top[i]+" ");
            }
            }else{
                System.out.println(-1);
            }
        }

    static void add(int a,int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static boolean  topSort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(d[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int t = queue.poll();
            top[cnt] = t;
            cnt++;
            for(int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                d[j] --;
                if(d[j]==0){
                    queue.offer(j);
                }
            }

        }return cnt >= n;
    }
}
