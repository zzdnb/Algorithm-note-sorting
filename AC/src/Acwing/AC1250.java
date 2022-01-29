package Acwing;

import java.util.Scanner;

public class AC1250 {
    static int[] p = new int[40010];
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n*n; i++){
            p[i] = i;
        }
        int res = 0;
        for(int i = 1; i <= m; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            String s = sc.next();

            int x = 0;
            if("D".equals(s)){
                x=  p[n*(a+1)+b];
            }else{
                x = p[n*a+b+1];
            }

            int pa = find(p[n*a+b]);
            int pb = find(x);
            if(pa==pb){
                res = i;
                break;
            }
            p[pa] = p[pb];

        }
        if(res == 0){
            System.out.println("draw");
        }else{
            System.out.println(res);
        }

    }
    static int find(int x){
        if(x!=p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
