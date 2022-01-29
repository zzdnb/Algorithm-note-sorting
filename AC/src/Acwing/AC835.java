package Acwing;

import java.util.Scanner;

public class AC835 {
    static int N = (int)1e5+10;
    static int ch[][] = new int[N][26];
    static int[] end = new int[N];
    static int idx = 0;
    static void insert(String s){
        int p = 0;
        for(int i = 0; i < s.length();i++){
            int j = s.charAt(i)-'a';
            if(ch[p][j]==0){
                ch[p][j] = ++idx;
            }
            p = ch[p][j];

        }
        end[p]++;
    }
    static void query(String s){
        int p = 0;
        boolean flag = false;
        for(int i = 0; i < s.length();i++){
            int j = s.charAt(i)-'a';
            if(ch[p][j]==0){
                flag = true;
                break;
            }
            p = ch[p][j];

        }
        if(flag){
            System.out.println(0);
        }else{
            System.out.println(end[p]);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- != 0){
            String s1 = sc.next();
            String s2 = sc.next();
            if(s1.equals("I")){
                insert(s2);
            }else{
                query(s2);
            }
        }
    }
}
