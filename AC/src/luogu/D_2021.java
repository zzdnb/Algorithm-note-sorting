package luogu;

import java.util.Scanner;

public class D_2021 {
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] st = new boolean[(int)2e6+20];
        int[] f = new int[(int)2e6+20];
        int[] primes = new int[(int)2e6+20];

        int cnt = 0;
        for(int i = 2; i <= 2e6+10; i++){
            if(!st[i]){
                primes[cnt++] = i;
            }
            //但凡是前边质数的倍数都不是质数，是合数 只需要将所有质数的倍数删了即可
            for(int j = 0;primes[j] <= (2e6+10)/i; j++){
                st[primes[j]*i] = true;
                if(i%primes[j] == 0){
                    break;
                }
            }

        }
        for(int i = 1,j = 0,k = 2; i <= 30; i++,k*=2){
            if(k > primes[cnt-1]){
                break;
            }
            for(int l = j; primes[l] < k;l++,j++){
                f[i]++;
            }
        }

        T = sc.nextInt();
        System.out.println(cnt);
        while(T-- != 0){
            int x = sc.nextInt();
            int k = 0,sum = 0;
            while (x!=0){
                if((x&1) == 1){
                    sum += f[k+1];
                }
                k++;
                x >>= 1;
            }

            System.out.println(sum);
        }




    }
}
