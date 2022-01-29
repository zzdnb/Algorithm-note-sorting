package Acwing;

import java.util.Scanner;

public class P {
    static int[] arr = new int[100005];
    static int ans ;
    static String s ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i)-'0';
        }
        dfs(0);
        System.out.println(ans);
    }
    static void dfs(int x){
        if(x == s.length()){
            ans ++;
            return;
        }
        if(arr[x]!=0){
            dfs(x+1);
        }
        if(arr[x]==0){
            return;
        }
        if(x+1 < s.length() && arr[x]*10+arr[x+1] <=26){
            dfs(x+2);
        }
    }
}
