package Acwing;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AC786 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(((o1, o2) -> {
            return o2-o1;
        }));
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            queue.offer(x);
        }
        for(int i = 0; i < k-1; i++){
            queue.poll();
        }
        System.out.println(queue.peek());

    }
}
