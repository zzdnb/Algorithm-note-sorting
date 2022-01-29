package niuke;

public class NC17 {
    public static void main(String[] args) {
        System.out.println(new NC17().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {

        String res = "";
        for(int i = 0; i<s.length(); i++){
            //奇数情况
            int l = i - 1;
            int r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                r ++;
                l --;
            }

            // r-1 - (l+1) + 1 = r - l - 1

            if(res.length()<r-l-1) res=s.substring(l+1,r);

            //偶数情况
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                r ++;
                l --;
            }

            if(res.length()<r-l-1) res=s.substring(l+1,r);

        }

        return res;

    }

}
