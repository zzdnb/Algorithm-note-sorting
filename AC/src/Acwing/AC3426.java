package Acwing;

import java.lang.reflect.Array;
import java.util.*;

public class AC3426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int cnt = 0;

            while (true) {
                boolean flag = true;
                for (int i = 1; i < n; i++) {
                    if (arr[i] != arr[i - 1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(cnt + " " + arr[0]);
                    break;
                }
                int[] tmp = new int[n];
                for (int i = 0; i < n; i++) {
                    tmp[(i + 1) % n] = arr[i % n] / 2;
                }

                for (int i = 0; i < n; i++) {
                    arr[i] = arr[i]/2+tmp[i];
                }

                for (int i = 0; i < n; i++) {
                    if (arr[i % n] % 2 != 0) {
                        arr[i % n]++;
                    }
                }

                cnt++;




            }  n = sc.nextInt();
        }
    }
}
