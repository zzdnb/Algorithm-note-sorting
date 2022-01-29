package leetcode;

import java.util.Arrays;

public class SB {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }
    public static  String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s[i] = ""+nums[i];
        }
        Arrays.sort(s,(o1,o2)->{
            String s1 = o1+o2;
            String s2 = o2+o1;
            System.out.println( s1+" "+s2);
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder();
        for(String x:s){
            sb.append(x);
        }
        int k = 0;
        while(k<sb.length()-1&&sb.charAt(k)=='0'){
            k++;
        }
        return sb.substring(k);
    }
}
