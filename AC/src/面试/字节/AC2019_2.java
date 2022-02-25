package 面试.字节;

import java.util.Scanner;

/**
 * @author 福尔摩东
 * @date 2022/2/24 20:48
 * @公众号 IT云家
 * @Github https://github.com/zzdnb
 * @博客 https://blog.csdn.net/qq_43688587
 * @网站 https://blog.zzdnb.cn
 */
public class AC2019_2 {

    static int n,k;
    static int[]arr;
    static int solve(int l,int u){
        int r = n-1;
        while(l < r){
            int mid = (l+r+1)>>1;
            if(arr[mid] <= u){
                l =  mid;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         k = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            int r = solve(i,arr[i]+k);
            if(r - i >= 2){
                long x = r-i;
                ans += x*(x-1)/2;
                ans = ans%(99997867);
            }

        }
        System.out.println(ans);
    }
}
