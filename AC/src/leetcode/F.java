package leetcode;


import java.beans.IntrospectionException;
import java.util.*;

public class F {
    //将源数组从起始位置srcPos开始将length长度的元素复制到目标数组，目标数组从destPos位置开始接收复制元素。
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] nums1 = {1, 4, 5};
        System.arraycopy(nums1, 0, nums, 3, nums1.length);
        System.out.println(Arrays.toString(nums));
        int[][] nums2 = new int[2][2];
        Arrays.sort(nums2, (o1, o2) -> o1[0]-o2[0]);
        Arrays.sort(nums2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.sort((o1, o2) -> o2-o1);
        list.sort((o1, o2) -> o1.get(0) - o2.get(0));
        list.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return 0;
            }
        });
        TreeSet<Integer> set = new TreeSet<Integer>((o1, o2) -> {
            return o2-o1;
        });
        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder sb1 = new StringBuilder(12);
        StringBuilder sb2 = new StringBuilder();//默认大小为16个字符
    }
}
