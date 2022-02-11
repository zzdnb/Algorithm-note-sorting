package pipi;

import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = {"red", "orange", "yellow", "green", "cyan", "blue", "purple" };
        boolean[] flag = new boolean[7];
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n-- != 0) {
                String ss = sc.next();
                for (int i = 0; i < 7; i++) {
                    if (ss.equals(s[i])) {
                        flag[i] = true;
                    }
                }

            }
            int cnt = 0;
            for (int i = 0; i < 7; i++) {
                if (!flag[i]) {
                    cnt++;
                }
            }
            System.out.println(cnt);
            for (int i = 0; i < 7; i++) {
                if (!flag[i]) {
                    System.out.println((char) ('A' + i));
                }
            }
            flag = new boolean[7];
        }
    }
}
