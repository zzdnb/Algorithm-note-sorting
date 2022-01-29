package Acwing;

import java.util.Scanner;

public class AC143 {
    static int N = (int)3e5+10;
    static int idx = 0;
    static int son[][] = new int[N][2];
    static void insert(int x){
        int p = 0;
        for(int i = 30; i >= 0; i--){
            //从最高位开始存
            int u = (x >> i) & 1;
            if(son[p][u] == 0){
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
    }
    static int query(int x){
        int p = 0, res = 0;
        for(int i = 30; i >= 0; i--){
            int u = (x >> i)&1;
            if(son[p][1-u] != 0){
                res += 1 << i;
                p = son[p][1-u];
            }else{
                p = son[p][u];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            insert(x);
            res = Math.max(res,query(x));
        }
        System.out.println(res);
    }
}
