package Acwing;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class KMP{

    static int N = (int) 1e5 + 10, M = (int) 1e6 + 10, n, m;
    static int[] ne = new int[N];
    static char[] s = new char[M], p = new char[N];
    static String S, P;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.valueOf(reader.readLine());
        P = reader.readLine();

        for (int i = 1; i <= n; i++) {
            p[i] = P.charAt(i - 1);

        }
        m =  Integer.valueOf(reader.readLine());
        S = reader.readLine();
        for (int i = 1; i <= m; i++) {
            s[i] = S.charAt(i - 1);
        }
        get_next();
        for(int i = 1;i <= n; i++){
            System.out.print(ne[i]+" ");
        }
        System.out.println();
        //kmp匹配
        for (int i = 1, j = 0; i <= m; i++) {
            //当j没有退回起点，并且当前的s[i]不能和j的下一个位置匹配的话，找到最少移动多少使得最大前缀=最大后缀，移动到ne[j]
            while (j != 0 && s[i] != p[j + 1]) {
                j = ne[j];
            }
            //如果两者匹配的话，j移到下一个位置
            if (s[i] == p[j + 1]) {
                j++;
            }
            //匹配成功
            if (j == n) {
                writer.write(i - n + " ");
                j = ne[j];
            }
        }
        writer.flush();
        writer.close();
        reader.close();

    }

    static void get_next() {
        //i从2开始，因为ne[1]肯定为0
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1]) {
                j = ne[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            ne[i] = j;

        }
    }
}
