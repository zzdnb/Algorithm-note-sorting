package Acwing;

import java.util.*;

public class AC53 {
    public static void main(String[] args) {

    }
    public List<Integer> getLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {
            return o2-o1;
        });
        for(int x:input){
            queue.offer(x);
            if(queue.size()>k){
                queue.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(queue.size()!=0){
            list.add(queue.poll());
        }
        list.sort(((o1, o2) -> {
            return o1-o2;
        }));
        return list;
    }
}
