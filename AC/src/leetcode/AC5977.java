package leetcode;

public class AC5977 {
    public static void main(String[] args) {
        System.out.println(new AC5977().minSwaps(new int[]{1}));
    }

    public int minSwaps(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            if (x == 1) {
                sum++;
            }
        }
//        int[] arr = new int[nums.length+1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int j = i+sum-1;
            if(j < nums.length){
                ans = Math.max(ans,nums[j]-nums[i]);

            }else{
//                System.out.println();
                ans = Math.max(ans,nums[nums.length-1]-nums[i]+nums[sum-(nums.length-i)]);
            }
            System.out.println(ans);
        }
        return sum - ans;

    }
}
