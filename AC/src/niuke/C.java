package niuke;

import java.util.Scanner;

public class C {
    static int N = (int) 1e6 + 10;
    static int[] arr = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = (int) -1e9;
        int min = (int) 1e9;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int res = 0;
         int l = (int)1e9,k = (int)1e9,ans = (int)1e9;
        for (int i = 0; i < n; i++) {
             if(arr[i]==min){
                 l = i;
             }

        }
        System.out.println(res);
    }
}

