package leetcode;

public class AC5 {
    //    public static String longestPalindrome(String s) {
//        String b = new StringBuilder(s).reverse().toString();
//        System.out.println(b);
//        int n = s.length();
//        int[][] arr = new int[n + 1][n + 1];
//        int end = 0, res = 0;
//        for (int i = 0; i < n; i++) {
//            char c1 = s.charAt(i);
//            for (int j = 0; j < n; j++) {
//                char c2 = b.charAt(j);
//                if (c1 == c2) {
//                    if (i == 0 || j == 0) {
//                        arr[i][j] = 1;
//                    } else {
//                        arr[i][j] = arr[i - 1][j - 1] + 1;
//                    }
//                }
//
//                if (res < arr[i][j]) {
//                    res = arr[i][j];
//                    end = i;
//                    System.out.println(j);
//                }
//
//            }
//
//
//        }
//        for(int i = 0; i <= n; i++){
//            for(int j = 0; j <= n; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(res + " " + end);
//        return s.substring(end - res+1, end+1);
//
//    }
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (res.length() < r - l - 1) {
                res = s.substring(l + 1, r );
            }
            System.out.println("1:"+res+" "+(r-l-1));
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (res.length() < r - l - 1) {
                res = s.substring(l + 1, r );
            }
            System.out.println("2:"+res+" "+(r-l-1));
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
