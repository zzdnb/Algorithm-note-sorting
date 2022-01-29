package Acwing;

import java.net.Inet4Address;
import java.util.PriorityQueue;
import java.util.Scanner;

public class S {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2)->{
            return o1-o2;
        });
        for (int x:arr){
            queue.offer(x);
        }
        int res = 0;
        while(!queue.isEmpty()){
            int a = 0, b = 0;
            if(queue.size()==1){
                System.out.println(res);
                return;
            }
            if (!queue.isEmpty()){
                a = queue.poll();
            }
            if(!queue.isEmpty()){
                b = queue.poll();
            }
            res +=a+b;
            queue.offer(a+b);
        }
    }
}
