package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AC5776 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[n-1-i][j];
                arr[n-1-i][j] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
