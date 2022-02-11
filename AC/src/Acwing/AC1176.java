package Acwing;

import java.util.Scanner;

public class AC1176 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] s1 = new String[n];
        String[] s2 = new String[n];
        for (int i = 0; i < n; i++) {
            s1[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            s2[i] = sc.next();
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            int[] ch = new int[26];
            for (int j = 0; j < n; j++) {
                int x = s1[j].charAt(i) - 'A', y = s2[j].charAt(i) - 'A';
                if (ch[x] == 0) {
                    ch[x] = 1;
                } else if (ch[x] == 2) {
                    flag = true;
                    break;
                }
                if (ch[y] == 0) {
                    ch[y] = 2;
                } else if (ch[y] == 1) {
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
