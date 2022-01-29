package Acwing;

import java.util.*;
class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int l = sc.nextInt();
        TreeMap<Double, int[]> map = new TreeMap<>();
        for(int i = 1; i <= l;i++){
            for(int j = 1; j <= i;j++){
                if((double)i/j>=(double)a/b){
                    map.put((double)i/j-(double)a/b,new int[]{i,j});
                }
            }
        }
        int c = map.get(map.firstKey())[0];
        int d = map.get(map.firstKey())[1];
        int e = gcd(c,d);
        System.out.println(c/e+" "+d/e);
    }
    public static int gcd(int a,int b){
        return b!=0?gcd(b,a%b):a;
    }
}