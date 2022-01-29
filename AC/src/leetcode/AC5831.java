package leetcode;

import java.util.Arrays;

public class AC5831 {
    public static void main(String[] args) {
        System.out.println(numberOfWeeks(new int[]{3}));
    }
        public static long numberOfWeeks(int[] m) {
            long res = 1;
            Arrays.sort(m);
            int n = m.length;
            long[] sum = new long[m.length+1];
            for(int i = 1; i <= n; i++){
                sum[i]+=m[i-1]+sum[i-1];
            }

            for(int i = 1; i < n; i++){
                System.out.println(res);
                if(sum[i]*2<sum[n]){
                    res = Math.max(res,sum[i]*2+1);
                }
                if(sum[i]*2==sum[n]){
                    res = Math.max(res,sum[i]*2);
                }
                if(sum[i]*2>sum[n]){
                    res = Math.max(res,sum[n]);
                }
            }
            return res;

        }
    }

