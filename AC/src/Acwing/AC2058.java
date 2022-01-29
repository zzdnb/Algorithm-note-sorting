package Acwing;

import java.util.Scanner;

public class AC2058 {
    static char[] ss1 ;
    static char[] ss2;
    static int gets1(){
        int res = 0;
        int x = 1;
        for(int i = ss1.length-1,cnt = 0;i >= 0; i--,cnt++){
            res +=(ss1[i]-'0')*x;
            x*=2;
        }
        return res;
    }
    static int gets2(){
        int res = 0;
        int x = 1;
        for(int i = ss2.length-1,cnt = 0;i >= 0; i--,cnt++){
            res +=(ss2[i]-'0')*x;
            x*=3;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        ss1 = s1.toCharArray();ss2 = s2.toCharArray();
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                char t1 = ss1[i],t2 = ss2[j];
                for(int b = '0'; b < '2'; b++){
                    for(int c = '0'; c < '3'; c++){
                        ss1[i] = (char)b; ss2[j] = (char)c;
                        if(gets1()==gets2()){
                            System.out.println(gets1());
                            return;
                        }
                    }
                }
                ss1[i] = t1;ss2[j] = t2;
            }
        }
    }
}
