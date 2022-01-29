package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class J {

}
class Sol {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{-5,-3,-3,-2,7,1},new int[]{-10,-5,3,4,6}));
    }
    public static int maximumScore(int[] nums, int[] multipliers) {
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        int res = 0;
        for(int x:multipliers){
            if(x*list.get(0)>x*list.get(list.size()-1)){
                res += x*list.get(0);
                list.remove(0);
            }else{
                res +=x*list.get(list.size()-1);
                list.remove(list.size()-1);
            }
            System.out.println(list.toString());
        }
        return res;
    }
}