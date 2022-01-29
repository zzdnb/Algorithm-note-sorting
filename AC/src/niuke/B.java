package niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(read.readLine());
        String s = read.readLine();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) == 'm') {

                if (s.charAt(i + 1) == 's') {
                    if (s.charAt(i + 2) == 'c') {
                        cnt1++;
                    }
                }
                if (s.charAt(i + 1) == 'c') {
                    if (s.charAt(i + 2) == 'c') {
                        cnt2++;
                    }
                }
            }
        }
        System.out.println(cnt1*cnt2);
    }
}
