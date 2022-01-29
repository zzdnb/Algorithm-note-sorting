package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class AC1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] tmp = new int[n+10];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        for(int[]x:arr){
            System.out.println(x[0]+" "+x[1]);
        }
        int r = arr[0][1];

        int ans = 1;
        tmp[1] = r;
        for (int i = 1; i < n; i++) {
            for(int j = 0; j < tmp.length; j++){
                System.out.print(tmp[j]+" ");
            }
            System.out.println();
            if (arr[i][1] > r) {
                tmp[++ans] = r = arr[i][1];
            } else {
                //加一保护边界
                int ll = 1, rr = ans+1 ;
                while (ll < rr) {
                    int mid = (ll + rr) >> 1;
                    if (tmp[mid] > arr[i][1]) {
                        rr = mid;
                    } else {
                        ll = mid + 1;
                    }
                }
                ans = ll-1;
            }
            System.out.println(ans);

        }
        System.out.println(ans);
    }
}
