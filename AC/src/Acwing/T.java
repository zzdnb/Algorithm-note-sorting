package Acwing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class T {
    public static int maxAscendingSum(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = nums[i];
        }
        if(nums.length==1){
            return nums[0];
        }
        for(int i = 1;i < nums.length; i++){
            if(nums[i]>nums[i-1]){
                arr[i] += arr[i-1];
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return nums[arr.length-1];
    }

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));

    }
}
