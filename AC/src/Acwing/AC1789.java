package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] arr = new int[26];
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(arr,0);
            for(int j = i+1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    for(int k = 0; k < 26; k++){
                        if(arr[k] == 1){
                            ans++;
                        }
                    }
                    break;
                }
                arr[s.charAt(j)-'A']++;
            }
        }
        System.out.println(ans/2);
    }
}
