package Acwing;

import java.util.Scanner;

public class AC4077 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();

        int res =  (int)1e9;
        for (int k = 'a'; k <= 'z'; k++) {
            int las = -1,curr = 0;
            for (int i = 0, j = 0; i < n; i++) {
                if (s.charAt(i)==k) {
                    curr = Math.max(curr, j - las);
                    las = j;

                }

                System.out.println(res);


            }
        }
    }
}
