package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AC5799 {
    //用来存储以i结尾的字符串中a到j的字母的个数
    static int[][] s = new int[100010][10];
    //cnt存储每一种数有多少个
    static int[] cnt = new int[1024];

    public static void main(String[] args) {
        System.out.println(wonderfulSubstrings("aba"));
    }


    public static long wonderfulSubstrings(String word) {
        int n = word.length();
        long res = 0;
        cnt[0]++;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (word.charAt(i - 1) - 'a' == j) {
                    s[i][j] = s[i - 1][j] + 1;
                } else {
                    s[i][j] = s[i - 1][j];
                }
            }
            //用cnt来保存啥？
            //cnt可以存储一共有10个字母中几个字母为奇数，将这些保存下来，最多就是1024种
            int state = 0;
            for (int j = 0; j < 10; j++) {
                state = state * 2 + s[i][j] % 2;
            }
            System.out.println(state);
            res += cnt[state];
            //奇偶性相同就是0，不同就是1  至多有一位不同，也就是说可以相同
            for (int j = 0; j < 10; j++) {
                System.out.println(cnt[state ^ (1 << j)]);
                //求只有一个数为1的
                //这种数最多有11种，比如与本身一样，一样的话就是0，所以0肯定是存在的，还有剩余10种，^后每一位上有一个1
                res += cnt[state ^ (1 << j)];
            }
            cnt[state]++;
        }
        for(int i = 1; i <= 3; i++ ){
            System.out.println(Arrays.toString(s[i]));
        }
        return res;
    }
}
