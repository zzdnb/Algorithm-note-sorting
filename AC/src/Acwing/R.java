package Acwing;

import java.util.ArrayList;
import java.util.Arrays;

public class R {
    public static void main(String[] args) {

    }

    public int findCenter(int[][] edges) {
        for (int[] x : edges) {
            Arrays.sort(x);
        }
        int a = edges[0][0];
        int b = edges[0][1];
        int len = edges.length - 1, cnt1 = 0, cnt2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (a == edges[i][j]) {
                    cnt1++;
                }
                if (b == edges[i][j]) {
                    cnt2++;
                }
            }

        }
        if(cnt1==len){
            return a;
        }else{
            return b;
        }

    }
}
