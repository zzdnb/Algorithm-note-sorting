package leetcode;

import java.util.HashSet;

public class AC5978 {
    public static void main(String[] args) {
        System.out.println(new AC5978().wordCount(new String[]{"uh"}, new String[]{"u","hur","k","b","u","yse","giqoy","lni","olqb","nemc"}));
    }


    public int wordCount(String[] startWords, String[] targetWords) {
        int ans = 0;

        HashSet<Long> set = new HashSet<>();
        for (String s : targetWords) {
            long cnt = 0;
            for (char c : s.toCharArray()) {
                cnt += 1 << (c-'a');
            }
            set.add(cnt);
            System.out.println(cnt);
        }
        for (String s : startWords) {
            boolean[]st = new boolean[26];
            long cnt = 0;
            for (char c : s.toCharArray()) {
                st[c-'a'] = true;
                cnt += 1 << (c-'a');
            }
            System.out.println(cnt);
            for (int i = 0; i < 26; i++) {
                if(!st[i]){
                    cnt += 1 << i;
                    if (set.contains(cnt)) {
                        ans++;
                        System.out.println(cnt);
                        set.remove(cnt);
                    }
                    cnt -= 1 << i;
                }

            }


        }
        return ans;
    }
}
