package luogu;

import java.util.Arrays;
import java.util.Scanner;

public class I {
    public static int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for(int i = 0, j = n-1; i < n; i++){
            while(i<j&&nums[i]+nums[j] > target){
                j--;
            }
            if(nums[i]+nums[j]<=target){
                res = (res+j-i)%(int)(1e9+7);
            }
        }
        return (int)res%(int)(1e9+7);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(purchasePlans(arr,target));
    }
}
