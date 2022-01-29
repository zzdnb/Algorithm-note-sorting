package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AC5916 {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{2,4,12},2,12));
    }
    public static int minimumOperations(int[] nums, int start, int goal) {
        //用bfs写，用map记录一下出现就停止搜,结果超过1000，就停止.
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        int cnt = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int x = queue.poll();
                if(x < 0 &&x >1000){
                    continue;
                }
                if(x == goal){
                    return cnt;
                }
                for(int xx:nums){
                    if(!set.contains(x+xx)){
                        queue.add(x+xx);
                        set.add(x+xx);
                    }
                    if(!set.contains(x-xx)){
                        queue.add(x-xx);
                        set.add(x-xx);
                    }
                    if(!set.contains(x^xx)){
                        queue.add(x^xx);
                        set.add(x^xx);
                    }
                }
            }


            cnt++;
        }
        return -1;
    }

}
