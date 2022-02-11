package luogu;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        long ans = 0;
        for(int j = 0; j < n; j++){
            for(int i = 0; i < j; i++){
                if(arr[i]*arr[j]<=k){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
