package lanqiao;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(read.readLine());
        List<Integer> list = new ArrayList<>();
        int a = 0, b = 0;
        while ((n--) != 0) {
            String[] s = read.readLine().split("\\s+");
            for (int i = 0; i < s.length; i++) {
                int c = Integer.parseInt(s[i]);
                if (list.contains(c)) {
                    b = c;
                } else {
                    list.add(c);
                }
            }
        }
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 != list.get(i + 1)) {
                a = list.get(i) + 1;
                break;
            }
        }
        System.out.println(a + " " + b);
    }
}