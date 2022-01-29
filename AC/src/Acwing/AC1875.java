package Acwing;

import java.util.*;

public class AC1875 {

    static int ans;
    static String s = "BESIGOM";
    static int[] arr1 = new int[26], arr2 = new int[26], arr3 = new int[26];
    static void dfs(int u, int x) {
        if (u == 7) {
            if ((arr3['B' - 'A'] + arr3['I' - 'A']) % 2 != 0 && (arr3['G' - 'A'] + arr3['O' - 'A'] + arr3['E' - 'A'] + arr3['S' - 'A']) % 2 != 0 && (arr3['M' - 'A'] % 2 != 0)) {
                return;
            }
//            System.out.println(x);
            ans += x;
            return;
        }
        int xx =  (s.charAt(u) - 'A');
        arr3[xx] = 1;
        dfs(u+1,x*arr2[xx]);
        arr3[xx] = 2;
        dfs(u+1,x*arr1[xx]);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int x = sc.nextInt();
            if (x % 2 == 0) {
                //偶数
                arr1[s.charAt(0) - 'A']++;
            } else {
                arr2[s.charAt(0) - 'A']++;
            }

        }

        System.out.println(ans);

    }


}

