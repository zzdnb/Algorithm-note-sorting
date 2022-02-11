package luogu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C_2021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1010];
        int n = sc.nextInt();
        int maxx = 0,minn = 1010;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            maxx = Math.max(arr[i],maxx);
            minn = Math.min(arr[i],minn);
        }

        for(int i = 0; i < n; i++){
            arr[i] = 100*(arr[i]-minn)/(maxx-minn);
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
