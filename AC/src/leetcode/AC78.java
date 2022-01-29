package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AC78 {
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int all = list.size();
            System.out.println(all);
            for(int j = 0; j <all;j++){
                List<Integer> tmp = new ArrayList<>(list.get(j));
                System.out.println(Arrays.toString(tmp.toArray()));
                tmp.add(nums[i]);
                list.add(tmp);
            }
        }
        return list;
    }
}
