package Acwing;

import java.util.Scanner;

public class AC4297 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long[] pre = new long[n+1];
        for(int i = 0 ;i < n; i++){
            arr[i] = sc.nextInt();
            pre[i+1] = pre[i]+arr[i];
        }
        long ans = 0;
        for(int i = 1; i <= n; i++){
            int l = i+1,r = n;
            while(l < r){
                int mid = l+r >> 1;
                if(pre[n] - pre[mid-1] <= pre[i]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            if(pre[n] - pre[r-1] == pre[i]){
                ans = Math.max(ans,pre[i]);
            }
        }
        System.out.println(ans);


    }
}
