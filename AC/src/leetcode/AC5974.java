package leetcode;

public class AC5974 {
    public static void main(String[] args) {
        System.out.println(new AC5974().numberOfWays("SSSPSSS"));

    }

    public int numberOfWays(String c) {
        int n = c.length(), MOD = (int) 1e9 + 7;
        int len = 0;
        long ans = 1;
        int pre = 0;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == 'S') {
                len++;
                if (len >= 3 && len % 2 != 0) {
                    
                    ans = ans * (i - pre) % MOD;
                }
                pre = i;
            }
        }
        return len > 0 && len % 2 == 0 ? (int) ans : 0;


    }
}
