package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC {
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(4));
    }

    public static int minNonZeroProduct(int p) {

        int mod = (int)1e9+7;
        int a = (1 << p )-1;
        int b =  a - 1;
        int c = b / 2;
        return (a%mod)*pow(b%mod,c,mod)%mod;
    }
    static int pow(int a,int b,int p){

        int res = 1;
        while(b!=0){
            if((b&1)==1){
                res = (int) Math.floorMod(res*1L*a,p);
            }
            a = (int) Math.floorMod(a*1L*a,p);
            b = b >> 1;
        }
        return res;
    }

}
