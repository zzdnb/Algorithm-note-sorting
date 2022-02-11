package zuoshen;

import java.util.Arrays;

public class C {
    static int[] arr = new int[]{1, 2, 3, 4, 4, 5, 6};

    public static void main(String[] args) {
        System.out.println(binarySearch(arr, 2));
    }

    public static int binarySearch(int []arr, int target) {
        int left = 0;
        int right = arr.length - 1; // 注意

        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; // 注意
            } else if (arr[mid] > target) {
                right = mid - 1; // 注意
            }
        }
        return -1;
    }

// https://www.acwing.com/blog/content/114/ 二分解释

    /**
     * l到r范围内求最大值
     */
     public static int process(int []arr,int l, int r){
         if (l==r){
             return arr[l];
         }
         int mid = l+(r-l) >> 1;
         int leftMax = process(arr,l,mid);
         int rightMax = process(arr,mid+1,r);
         return Math.max(leftMax,rightMax);
     }
}
