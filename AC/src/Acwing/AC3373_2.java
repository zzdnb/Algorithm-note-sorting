package Acwing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AC3373_2 {
    static Deque<Integer> div(Queue<Integer> queue, int b){
        Deque<Integer> tmp = new LinkedList<>();
        int cnt = queue.size();
        int r = 0;
        while(cnt-- != 0){
            r = r * 10 + queue.poll();
            tmp.offer(r/b);
            r %=b;
        }
        while(tmp.size() != 0 && tmp.peek()==0){
            tmp.poll();
        }
        return tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String x = sc.next();

            Deque<Integer> queue = new LinkedList<>();
            for(char c: x.toCharArray()){
                queue.offer(c-'0');
            }

            StringBuilder res = new StringBuilder();
            if("0".equals(x)){
                res.append("0");
            }else{
                while(!queue.isEmpty()){
                    System.out.println(queue.peekLast());
                    res.append(queue.peekLast()%2);
                    queue =  div(queue,2);
                }
            }
            System.out.println(res.reverse());
        }
    }
}
