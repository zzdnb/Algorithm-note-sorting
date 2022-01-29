package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NC97 {
    public static void main(String[] args) {
        new NC97().topKstrings(new String[]{"abcd","abcd","abcd","pwb2","abcd","pwb2","p12"},3);
    }

    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Long, String> map1 = new HashMap<>();
        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            long tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                tmp += tmp * 10 + s.charAt(i);
            }
            map1.put(tmp,s);
        }
        PriorityQueue<long[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return -map1.get(o1[0]).compareTo(map1.get(o2[0]));
            }
            return o1[1] < o2[1] ? -1 : 1;
        });

        for (String s : map.keySet()) {
            long tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                tmp += tmp * 10 + s.charAt(i);
            }
            queue.offer(new long[]{tmp, map.get(s)});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        String[][] ans = new String[k][2];
        while (queue.size() != 0) {
            long[] t = queue.poll();
            ans[--k][0] = map1.get(t[0]);
            ans[k][1] = String.valueOf(t[1]);
//            System.out.println(map1.get(t[0]));
        }
        for(int i = 0; i < 3; i++){
            System.out.println(Arrays.toString(ans[i]));
        }
        return ans;


    }
}
