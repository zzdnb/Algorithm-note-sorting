package Acwing;

import java.io.*;
import java.util.*;

public class AC154 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
         int[] nums = new int[n+1];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        Deque<Integer> qMin = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++){
            //检查是否出了队列，因为i-k+1 ~ i,出了的话就不行了
            while(!qMin.isEmpty() && qMin.peekFirst() < i-k+1){
                qMin.pollFirst();
            }
            //如果新加入的数比队列的后面的数小，就入队
            while(!qMin.isEmpty() && nums[i] < nums[qMin.peekLast()]){
                qMin.pollLast();
            }
            qMin.add(i);

            if(i+1>=k){
                writer.write(nums[qMin.peekFirst()] + " ");
            }
        }
        writer.write("\n");

        // max
        Deque<Integer> qMax = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++){
            while(!qMax.isEmpty() && qMax.peekFirst() < i-k+1){
                qMax.pollFirst();
            }
            while(!qMax.isEmpty() && nums[i] > nums[qMax.peekLast()]){
                qMax.pollLast();
            }
            qMax.add(i);

            if(i+1>=k){
                writer.write(nums[qMax.peekFirst()] + " ");
            }
        }
        writer.write("\n");

        writer.flush();
        reader.close();
        writer.close();


    }
}
