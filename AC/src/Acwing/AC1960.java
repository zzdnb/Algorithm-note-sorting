package Acwing;

import java.util.*;

public class AC1960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long b = sc.nextLong();
        int[] arr = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<String, Integer> map = new HashMap<>();
        String s = "";
        while (true) {
            s = "";
            for (int j = 0; j < n; j++) {
                s += (char) ('0' + arr[j]);
            }
            if (map.containsKey(s)) {
                break;
            }
            map.put(s, cnt);
            cnt++;
            System.out.println(s);
            int[] tmp = arr.clone();
            for (int j = 0; j < n; j++) {
                int x = j - 1;
                if (j - 1 == -1) {
                    x = n - 1;
                }
                if (tmp[x] == 1) {
                    arr[j] = 1 - arr[j];
                }
            }
        }
//        System.out.println(s);
//        System.out.println(map.get(s));
        int start = map.get(s);
        int total = map.size();
        int cycle = total - start;
        long index = b;
        if (b > start) {
            index = (b - start) % cycle + start;
        }
        for (String ss : map.keySet()) {
            if (index == map.get(ss)) {

                for (int k = 0; k < ss.length(); k++) {
                    System.out.println(ss.charAt(k));
                }
                break;
            }

        }
    }
}
