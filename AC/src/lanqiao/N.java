package lanqiao;

import java.util.Scanner;

public class N {
    static int N = (int) 1e6 + 10;
    static int[] p = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i < N; i++){
            p[i] = i;
        }
        for(int i = 1; i <= n; i++){
            int x = sc.nextInt();
            x = find(x);
            p[x] = x+1;
        }
    }

    static int find(int x) {
        if (p[x] != x) {
            System.out.println(p[x]+" "+x);
            p[x] = find(p[x]);
        }
        System.out.println("XXXX");
        return p[x];
    }
}
