package Acwing;

import java.util.Scanner;
import java.util.zip.Inflater;

public class Floyd {
    static int N = 210;
    static int n,m,k,INF = (int)1e9;
    static int[][] d = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j){
                    d[i][j] = 0;
                }else{
                    d[i][j] = INF;
                }
            }
        }
        for(int i = 0 ; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            d[x][y] = Math.min(d[x][y],z);
        }
        floyd();
        while(k-- !=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(d[a][b] == INF){
                System.out.println("impossible");
            }else{
                System.out.println(d[a][b]);
            }
        }
    }
    static void floyd(){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    d[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
    }
}
