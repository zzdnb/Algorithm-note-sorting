package Acwing;

import java.util.Scanner;

public class AC142 {
    static int N = (int)1e6+10;
    static int[][] son = new int[N][26];
    static int[] end = new int[N];
    static int idx;
    static void insert(String s){
        int p = 0;
        for(int i =0; i < s.length(); i++){
            int j = s.charAt(i)-'a';
            if(son[p][j] == 0){
                son[p][j] = ++idx;
            }
            p = son[p][j];
        }
        end[p]++;
    }
    static void query(String s){
        int p = 0;
        int res = 0;
        for(int i =0; i < s.length(); i++){
            int j = s.charAt(i)-'a';
            if(son[p][j] == 0){
                break;
            }
            p = son[p][j];
            res += end[p];
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while(n-- != 0){
            String s = sc.next();
            insert(s);
        }
        while(m-- != 0){
            String s = sc.next();
            query(s);
        }
    }
}
