package niuke;

import java.util.Arrays;

public class NC91 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NC91().LIS(new int[]{1,2,8,6,4})));
    }
    int[]dp,tmp;
    int len = 0;
    int find(int x){
        int l = 0, r = len;
        while(l < r){
            int mid = (l+r)>>1;
            if(dp[mid] >= x ){
                r = mid;
            }else{
                l = mid+1;
            }

        }
        return l;
    }
    public int[] LIS (int[] arr) {
        // write code here
        int n = arr.length;
        dp = new int[n];
        tmp = new int[n];
        dp[0] = arr[0];
        tmp[0] = 0;

        for(int i = 1; i < n; i++){
            if(arr[i] > dp[len]){
//                System.out.println(arr[i]);
                dp[++len] = arr[i];
                tmp[i] = len;
            }else{
                int j = find(arr[i]);
                dp[j] = arr[i];
                tmp[i] = j;
            }
        }
        System.out.println(len);
        int[] ans = new int[len+1];
        for(int i = n-1; i >= 0; i--){
            if(tmp[i] == len){
                ans[len--] = arr[i];
            }
        }
        return ans;
    }
}
