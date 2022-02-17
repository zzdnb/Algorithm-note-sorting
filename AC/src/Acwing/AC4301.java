package Acwing;

import java.util.Scanner;

public class AC4301 {
    static int[] arr = new int[110];
    static int n;
    static boolean st = false;
    static void dfs(int u,int k){
        if(st){
            return ;
        }
        if(u == n ){
            st = true;
        }
        for(int j = u+1; j <= n; j++){
             if(arr[j] - arr[u] == arr[k]){
                 dfs(j,k);
             }else if(arr[j] - arr[u] > arr[k]){
                 break;
             }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String s = sc.next();
        for(int i = 1; i <= n; i++){
            arr[i] = s.charAt(i-1)-'0';
        }
        for(int i = 1; i < n; i++){
            arr[i+1] = arr[i]+ arr[i+1];
        }
        for(int i = 1; i < n ;i++){
            if(!st){
                dfs(i,i);
            }


        }
        System.out.println(st?"YES":"NO");

    }
}
