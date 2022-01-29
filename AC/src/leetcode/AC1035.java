package leetcode;

public class AC1035 {
    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1,4,2},new int[]{1,2,4}));
    }
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 1; i <= nums1.length; i++){
            for(int j = 1; j <= nums2.length; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
