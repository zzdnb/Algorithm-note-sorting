package Acwing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AC1118 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N = 10,len,ans = N,n;
    static int f[] = new int[N];
    static int gcd(int a,int b){
        return b!=0?gcd(b,a%b):a;
    }
    static boolean check(int j,int u){

        for(int i = 0; i < list.get(j).size(); i++){
            if (gcd(list.get(j).get(i),u) > 1){
                return false;
            }
        }
        return true;
    }
    static void dfs(int u,int len){
        if(u == n){
            ans = Math.min(len,ans);
            return ;
        }
        for(int i = 0; i < len; i++){
            if(check(i,f[u])){
                list.get(i).add(f[u]);
                dfs(u+1,len);
                list.get(i).remove(list.get(i).size()-1);
            }
        }

        list.get(len).add(f[u]);
        dfs(u+1,len+1);
        list.get(len).remove(list.get(len).size()-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            f[i] = sc.nextInt();
            ArrayList<Integer> tmp = new ArrayList<>();
            list.add(tmp);
        }
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i).size());
//        }
       dfs(0,0);
        System.out.println(ans);
        int [][]meetings = new int[2][2];
        Arrays.sort(meetings,( o1,  o2)->{
            return o1[2] - o2[2] ;
        });
    }
}
