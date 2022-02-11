package leetcode;

import java.util.Arrays;

public class AC6000 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AC6000().sortEvenOdd(new int[]{4,1,2,3})));
    }

    public int[] sortEvenOdd(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        int n = nums.length;
        int len1 = 0, len2 = 0;
        if (n % 2 == 0) {
            len1 = n / 2;
            len2 = n / 2;
        } else {
            len1 = n / 2 + 1;
            len2 = n / 2;
        }
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        for (int i = 0, j = 0, k = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums1[j++] = nums[i];
            } else {
                nums2[k++] = nums[i];
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        for (int i = 0, j = 0, k = len2-1; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums1[j++];
            } else {
                nums[i] = nums2[k--];
            }
        }
        return nums;
    }

}
