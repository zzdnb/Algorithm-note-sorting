package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC3629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        double sum = 0;
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            if (flag) {
                sum += Math.PI * arr[i] * arr[i];
            }else{
                sum -= Math.PI*arr[i]*arr[i];
            }
            flag = !flag;
        }
        System.out.printf("%.6f", sum);
    }
}
