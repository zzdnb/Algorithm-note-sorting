package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

class D {
    static int[][] arr = new int[100010][26];
    static int[] end = new int[100010];
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(read.readLine());
        while ((n--) != 0) {
            String[] s = read.readLine().split(" ");
            if (s[0].equals("I")) {
                insert(s[1]);
            } else {
                System.out.println(query(s[1]));
            }
        }
    }

    public static void insert(String ss) {
        char[] ch = ss.toCharArray();
        int p = 0;
        for (int i = 0; i < ch.length; i++) {
            int s = ch[i] - 'a';
            if (arr[p][s] == 0) {
                arr[p][s] = ++idx;
            }
            p = arr[p][s];
            System.out.println(s+" "+p);
        }
        end[p]++;
    }

    public static int query(String ss) {
        char[] ch = ss.toCharArray();
        int p = 0;
        for (int i = 0; i < ch.length; i++) {
            int s = ch[i] - 'a';
            if (arr[p][s] == 0) {
                return 0;
            }
            p = arr[p][s];
            System.out.println(s+" "+p);
        }
        return end[p];
    }
}