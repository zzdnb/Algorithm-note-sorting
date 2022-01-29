package leetcode;

import java.util.Arrays;

public class AC5980 {
    public  String[] divideString(String s, int k, char fill) {
        int cnt = s.length();
        int n = cnt/k;
        int mod = cnt%k;
        String[]ans = new String[n+mod];
        for(int i = 0; i < n; i++){
            String ss="";
            for(int j = 0; j < k; j++){
                ss += s.charAt(i*k+j);
            }
            ans[i] = ss;
        }
        String ss="";
        if(mod!=0){
            for(int i = 0; i < mod; i++){
                ss += s.charAt(n*k+i);
            }
            for(int i = 0; i < k-mod; i++){
                ss +=fill;
            }
            ans[ans.length-1] = ss;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AC5980().divideString("abcd",3,'x')));

    }
}
