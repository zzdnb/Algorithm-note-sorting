package leetcode;

public class SC {
    public static void main(String[] args) {
        System.out.println(minAbsoluteSumDiff(new int[]{1,7,5},new int[]{2,3,5}));
    }
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long max = 0;
        int index1 = 0;
        long sum = 0;
        for(int i = 0; i < nums1.length; i++){
            sum += (long)Math.abs((nums1[i]-nums2[i]))%(int)(1e9+7);
            max = (long)Math.max(Math.abs(nums1[i]-nums2[i]),max);
        }
        for(int i = 0; i < nums1.length; i++){
           if(max == Math.abs(nums1[i]-nums2[i])){
               index1 = i;
               break;
            }
        }
        System.out.println(index1);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums1.length; i++){
            min = Math.min(min,Math.abs(nums1[i]-nums2[index1]));
        }
        int index2 = 0;
        for(int i = 0; i < nums1.length; i++){
            if(min == Math.abs(nums1[i]-nums2[index1])){
                 index2 = i;
                 break;
            }
        }
        System.out.println(index2);
        return (int) ((sum-Math.abs(nums1[index1]-nums2[index1])+Math.abs(nums1[index2]-nums2[index1]))%((int)1e9+7));

    }
}
