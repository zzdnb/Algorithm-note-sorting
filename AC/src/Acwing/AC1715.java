package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]nums = new int[1010];
        while(n-- != 0){
            int l = sc.nextInt(),r = sc.nextInt(),x = sc.nextInt();
            nums[l] += x;
            nums[r] -= x;
        }
        int ans = 0,pre = 0;
        for(int i = 1; i <= 1000; i ++){
            pre += nums[i];
            ans = Math.max(ans,pre);
        }
        System.out.println(pre);


    }
}
