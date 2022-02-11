package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC1738 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n],nn = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        nn[0] = 1;
        for(int i = 1; i < n-1; i++){
            if(nums[i] - nums[i-1] > nums[i+1] - nums[i]){
                nn[i] = 1;
            }
        }
        int ans = 0;
        for(int i = 1; i < n; i++){
            if(nn[i] == 0 && nn[i-1] == 1){
                ans++;
                if(i-2>=0 && nn[i-2] == 1 && i+1 < n && nn[i+1] == 0){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
