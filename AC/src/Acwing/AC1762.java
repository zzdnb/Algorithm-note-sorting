package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC1762 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] index = new int[n+1];
        String[] s = new String[n+1];
        String[] ans = new String[n+1];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            index[i+1] = i+1;
        }
        for(int i = 0; i < n; i++){
            s[i] = sc.next();
        }
        for(int i = 0; i < 3; i++){
            int[]tmp = new int[n+1];
            for(int j = 1; j <= n; j++){
                tmp[arr[j-1]] = index[j];
            }
            index = tmp.clone();
//            System.out.println(Arrays.toString(index));
        }
        for(int i = 1; i <= n; i++){
            ans[index[i]] = s[i-1];
        }
        for(int i = 1; i <= n; i++){
            System.out.println(ans[i]);
        }
//        System.out.println(Arrays.toString(ans));

    }
}
