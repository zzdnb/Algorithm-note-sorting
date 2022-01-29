package leetcode;

public class AC5918 {
    public static void main(String[] args) {
        System.out.println(new AC5918().countVowelSubstrings("cuaieuouac"));

    }
    public int countVowelSubstrings(String word) {
        //统计每一个

        int cnt = 0;
        int[] ch = new int[26];
        int n = word.length();
        for(int i = 0; i < n-4; i++){
            for(int j = i+4; j < n; j++){
                for(int k = i; k <= j;k++){
                   ch[word.charAt(k)-'a']++;
                }
                int a = ch['a'-'a'];
                int e = ch['e'-'a'];
                int ii = ch['i'-'a'];
                int o = ch['o'-'a'];
                int u = ch['u'-'a'];
                if( a> 0&&e>0&&o>0&&ii>0&&u>0&&(a+e+ii+o+u)==j-i+1){
                    cnt++;
                }
                ch = new int[26];
            }
        }
        return cnt;
    }
}
