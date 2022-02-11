package Acwing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AC1750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[2];
            tmp[0] = sc.nextInt();
            tmp[1] = sc.nextInt();
            list.add(tmp);
        }
        list.sort((o1, o2) -> {
            return o1[0] - o2[0];
        });
        ArrayList<int[]> tmp = (ArrayList<int[]>) list.clone();

        int res = 0;
        for (int i = 0; i < n; i++) {
            list.remove(i);
            int l = -1, r = -1;
            int ans = 0;
            for (int j = 0; j < n - 1; j++) {
                if (list.get(j)[0] > r) {
                    if (l != -1) {
                        ans += r - l;
                    }
                    l = list.get(j)[0];
                    r = list.get(j)[1];
                } else {
                    r = Math.max(r, list.get(j)[1]);
                }
            }
            if(l != -1){
                ans += r-l;
            }
            res = Math.max(res,ans);
            list = (ArrayList<int[]>) tmp.clone();
        }
        System.out.println(res);
    }
}
