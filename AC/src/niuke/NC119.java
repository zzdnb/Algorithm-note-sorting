package niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NC119 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });
        for(int x:input){
            queue.offer(x);
            if(queue.size()>k){
                queue.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int x:queue){
            list.add(x);
        }
        return list;

    }
}
