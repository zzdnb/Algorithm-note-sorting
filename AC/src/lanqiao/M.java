package lanqiao;

import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        long res = 0;
//        int[] dp = new int[n+1];
//        for(int i = 1; i <= n; i++){
//            int a = sc.nextInt();
//            dp[i] +=dp[i-1]+a;
//            res +=dp[i-1]*a;
//        }
        long sum=0,res=0;
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            sum+=res*x;
            res+=x;
        }
        System.out.println(sum);
    }


}
