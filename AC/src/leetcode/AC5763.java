package leetcode;

import java.util.Arrays;

public class AC5763 {
    public static boolean checkZeroOnes(String s) {
        int[] arr = new int[105];
        Arrays.fill(arr,1);
        int cnt1 = s.contains("1")?1:0;
        int cnt2 = s.contains("0")?1:0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i)=='1'&&s.charAt(i-1)=='1'){
                arr[i] = arr[i-1]+1;
                cnt1 = Math.max(cnt1,arr[i]);
            }

            if(s.charAt(i)=='0'&&s.charAt(i-1)=='0'){
                arr[i] = arr[i-1]+1;
                cnt2 = Math.max(cnt2,arr[i]);
            }
        }
        if(cnt1 > cnt2){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkZeroOnes("110100010"));
    }
}
