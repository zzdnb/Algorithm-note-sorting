package Acwing;

import java.util.Scanner;

public class AC886 {
    static int mod = (int)1e9+7;
    static int[] fact = new int[(int)1e5+10],infact = new int[(int)1e5+10];
    static long qmi(int a, int k, int p){
        long res = 1;
        while( k > 0){
            if( (k & 1) != 0 ) {
                res = res * a % p;
            }
            a =(int) ((long) a * a % p);
            k >>= 1;
        }
        return (int) res;
    }
    public static void main(String[] args) {
        fact[0] = infact[0] = 1;
        for(int i = 1; i < fact.length; i++){
            fact[i] =(int) ((long)fact[i - 1] * i % mod);
            infact[i] = (int) ((long) infact[i - 1] * qmi(i, mod - 2, mod ) % mod);
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- !=0){
            int a=  sc.nextInt();
            int b = sc.nextInt();
            int res = (int) ((long) fact[a] * infact[a - b] % mod * infact[b] % mod);
            System.out.println(res);

        }
    }
}
