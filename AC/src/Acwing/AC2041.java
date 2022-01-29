package Acwing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AC2041 {
    static int[] p;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        p = new int[n+2];
//        System.out.println(Arrays.toString(arr));
        while(m-- != 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            p[a]+=1;
            p[b+1]-=1;
        }
        for(int i = 1; i <= n; i++){
            p[i] += p[i-1];
        }
        Arrays.sort(p);
        System.out.println(p[p.length/2+1]);
    }
}
