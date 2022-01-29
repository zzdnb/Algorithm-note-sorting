package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AC1863 {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1,5,6}));
        System.out.println(Integer.MAX_VALUE);
    }
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            int size = list.size();
            for(int j = 0; j < size; j++){
                List<Integer> list1 = new ArrayList<>(list.get(j));
                list1.add(nums[i]);
                list.add(list1);
            }
        }
        int res = 0;
        for(List<Integer> x: list){
            int ans = 0;
            for(int y:x){
                ans ^= y;
            }
            res += ans;
        }
        return res;
    }
}
