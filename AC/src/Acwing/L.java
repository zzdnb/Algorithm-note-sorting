package Acwing;

import java.io.*;

public class L {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = read.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int t = Integer.valueOf(s[1]);
        String w = read.readLine();
        int P = 131;
        long[] h = new long[n+10];
        long[] p = new long[n+10];
        p[0] = 1;
        for (int i = 1; i <=n; i++) {
            p[i] = p[i-1] * P;
            h[i] = h[i-1] * P+w.charAt(i-1);
        }
        while (t-- >0){
            s = read.readLine().split(" ");
            int l1 = Integer.valueOf(s[0]);
            int r1 = Integer.valueOf(s[1]);
            int l2 = Integer.valueOf(s[2]);
            int r2 = Integer.valueOf(s[3]);
            String out =  h[r1] - h[l1 - 1] * p[r1 - l1 + 1] == h[r2] - h[l2 - 1] * p[r2 - l2 + 1] ?
                    "Yes" : "No";
            write.write(out+"\n");

        }
        write.flush();
    }
}
