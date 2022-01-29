package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AC5919 {
    public static void main(String[] args) {
        System.out.println(new AC5919().countVowels("aba"));
    }
    public long countVowels(String word) {
        //求6 - 3
        int n = word.length();
        int cnt = 0;
        long ans = 0;
        long arr[] = new long[100010];

        for(int i = 0; i < n; i++){
            if(word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u') {
                arr[i+1] = arr[i]+1;
            }else{
                arr[i+1] = arr[i];
            }
//         System.out.println(arr[i+1]);
        }
        for(int i = 1; i <= n; i++){
            arr[i] += arr[i-1];
            System.out.println(arr[i]);
        }
        for(int i = 1; i <= n; i++){
            ans += (arr[n] - arr[i-1]);
        }
        return ans;
    }
}
// a b a c a 1 1 2 2 3
//