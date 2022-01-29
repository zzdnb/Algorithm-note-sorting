package Acwing;



import java.util.ArrayList;

import java.util.Scanner;

public class Kruskal {
    static int n, m;
    static int[] p = new int[20010];
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            list.add(arr);
        }
        list.sort((o1,o2)->{
            return o1[2]-o2[2];
        });

//        for(int i = 0; i < m; i++){
//            System.out.println(Arrays.toString(list.get(i)));
//
//        }
        for(int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int res = 0, cnt = 0;
        for(int i = 0; i < m; i++){
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            int w = list.get(i)[2];
            if(find(a)!=find(b)){
                p[find(a)] = p[find(b)];
                cnt ++;
                res += w;
            }
        }
        if (cnt == n-1){
            System.out.println(res);
        }else{
            System.out.println("impossible");
        }
    }
    static int find(int x){
        if(x!=p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }

}

