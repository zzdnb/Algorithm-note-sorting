package leetcode;

import java.util.PriorityQueue;
import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> queue = new PriorityQueue<double[]>((o1, o2) -> {
            double x = (o2[0] + 1) / (o2[1] + 1) - (o2[0] / o2[1]);
            double y = (o1[0] + 1) / (o1[1] + 1) - (o1[0] / o1[1]);
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
            return 0;
        });
        for (int[] c : classes) {
            queue.offer(new double[]{c[0], c[1]});
        }
        while (extraStudents > 0) {
            double[] c = queue.poll();
            c[0] += 1.0;
            c[1] += 1.0;
            queue.offer(c);
            extraStudents--;
        }
        double res = 0;
        while (!queue.isEmpty()) {
            double[] c = queue.poll();
            res += c[0] / c[1];
        }
        return res / n;
    }
}
