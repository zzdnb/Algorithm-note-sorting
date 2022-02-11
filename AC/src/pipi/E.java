package pipi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.valueOf(read.readLine());
        String s = read.readLine();
        int n = s.length();
        int now = 0;
        int cnt = 0;
        int c2 = 0;
        long ans = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = s.charAt(i) - '0';
            if (now + cur <= k) {
                now += cur;
                if (cur == 2) {
                    c2++;
                }
                cnt++;
            }
            else {
                if (cur == 1) {
                    if (c2!=0) {
                        c2--;
                        now -= 2;
                        now++;
                    }
                }
            }
            ans += cnt;
        }
        System.out.println(ans);
    }
}
