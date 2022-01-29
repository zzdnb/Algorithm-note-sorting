package Acwing;

import lanqiao.M;

import java.util.*;


public class ACW10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- != 0){
            char[] s = sc.next().toCharArray();
            int x = Integer.parseInt(new String(s));
            int l = 1,r = 50000;
            while(l < r){
                int mid = l+r+1 >> 1;
                if(mid * mid <= x){
                    l = mid;
                }else {
                    r = mid - 1;
                }
            }
            int res = -1;
            while(r >= 1){
                char[] p = (""+r*r).toCharArray();
                int j = 0;
                for(int i = 0; i < s.length; i++) {
                    if (j < p.length && s[i] == p[j]) {
                        j++;
                    }
                }
                    if(j == p.length){

                        res = s.length - p.length-1;
                        break;
                    }

                r--;
            }
            System.out.println(res);
        }

    }
}

