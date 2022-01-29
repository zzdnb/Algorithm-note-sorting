package leetcode;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class LC5850 {
    public static void main(String[] args) {
        System.out.println(minimizeTheDifference(new int[][]{{2,2},{2,10},{6,7},{4,2},{1,10},{8,1},{8,5}},33));
    }

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        for(int i = 0; i < 30; i++){
            StringBuilder s = new StringBuilder(new BigInteger(String.valueOf(i)).toString(2));
            int len = s.length();
            for(int j = 0; j < n-len;j++){
                s.insert(0, '0');
;            }
            boolean flag = false;
            for(String ss:nums){
                if(s.toString().equals(ss)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return s.toString();
            }
        }
        return "";
    }
    public static int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[m];

        for(int i = 0; i < n; i++){
            Arrays.sort(mat[i]);
            for(int j = 0; j < m; j++){
                ans[j] += mat[i][j];
            }
        }

        if(ans[0] >= target){
            return Math.abs(target-ans[0]);
        }
        if(ans[m-1] <= target){
            return Math.abs(target-ans[m-1]);
        }
        int [] nn = new int[n+1];
        int flag = 0;
        for(int i =1; i < m-1; i++){
            if(target >= ans[i]){
                flag = i;
                break;
            }
        }
        for(int i = 0; i < n; i++){
            nn[i+1] = mat[i][flag+1]-mat[i][flag];
        }

        int res = Math.abs(ans[flag+1]-target);

        int []dp = new int[10000];
        for(int i = 1; i <= n; i++){
            for(int j = res; j >= nn[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-nn[i]]+nn[i]);
            }

        }



        return  res - dp[res];
    }
}
