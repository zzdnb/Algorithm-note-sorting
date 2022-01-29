package leetcode;

import java.util.*;

public class AC5941 {
    public static void main(String[] args) {
        System.out.println(new AC5941().findAllPeople(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1));
    }

    int[] p = new int[(int) (1e5 + 10)];

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int f) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        p[f] = p[0];
        Arrays.sort(meetings, (o1, o2) -> {
            return o1[2] - o2[2];
        });
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < meetings.length; ) {
            int x = meetings[i][2];
            while (!queue.isEmpty()) {
                queue.poll();
            }
            int j = 0;
            for (j = i; j < meetings.length && meetings[j][2] == x; j++) {

                p[find(meetings[j][1])] = find(meetings[j][0]);
                queue.offer(meetings[j][0]);
                queue.offer(meetings[j][1]);
            }
            i = j;
            while (!queue.isEmpty()) {
                int tmp = queue.poll();
                if(p[find(tmp)] != find(0)){
                    p[tmp] = tmp;
                }
            }

        }
        for(int i = 0; i <= n; i++){
            if(find(i) == find(0)){
                ans.add(i);
            }
        }

        return ans;

    }
}
