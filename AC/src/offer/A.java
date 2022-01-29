package offer;


import java.util.Hashtable;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(firstNotRepeatingChar(s));
    }
    public static char firstNotRepeatingChar(String s) {
        Hashtable<Character,Integer> map = new Hashtable<>();
        for(char x: s.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
            System.out.println(x+" "+map.get(x));
        }
        for(char c: map.keySet()){
            if(map.get(c)==1){
                return c;
            }
        }
        return '#';
    }
}
class S {
    public static void main(String[] args) {

        System.out.println(duplicateInArray(new int[]{2,3,1,2,3}));
    }
    public static int duplicateInArray(int[] nums) {
        int len = nums.length;
        if(nums==null||len==0) {
            return -1;
        }

        for(int i =0;i<len;i++){
            if(nums[i]<0||nums[i]>len-1) {
                return -1;
            }
        }
        for(int i = 0;i<len;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        System.out.println();
        return -1;
    }

}