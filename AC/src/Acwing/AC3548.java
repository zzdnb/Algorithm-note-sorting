package Acwing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AC3548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer>  queue = new LinkedList<>();
        LinkedList<Integer>  queue2;

        while(n-- !=0){
            String s = sc.next();
            int x = sc.nextInt();
            if("L".equals(s)){
                queue.addFirst(x);
            }else if ("R".equals(s)){
                queue.addLast(x);
            }else{
                queue2 = queue;
                System.out.println(queue2.size());
                int cnt = 0;
                while(queue2.getFirst()!=null&&queue2.getFirst()==x){
                    cnt++;
                    queue2.pollFirst();
                }

                System.out.println(Math.min(queue.size()-1-cnt,cnt));
            }
        }

    }
}
