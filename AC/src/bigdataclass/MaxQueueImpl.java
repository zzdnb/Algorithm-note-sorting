package bigdataclass;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueueImpl implements MaxQueue {
    //此题关键是取最大值，因此可以使用一个思想就是保证数列始终递减即可
    Deque<Integer> dq = new LinkedList<>();
    Queue<Integer> q = new LinkedList<>();

    @Override
    public void add(int v) {
        q.add(v);
        while(!dq.isEmpty() && dq.peekLast() < v){ // 是小于而不是小于等于
            dq.pollLast();
        }
        dq.addLast(v);



    }

    @Override
    public int poll() {
        if(q.size() == 0) {
            return -1;
        }

        if(dq.peekFirst().equals(q.peek())){
            dq.pollFirst();
        }
        return q.poll();



    }

    @Override
    public int pollMax() {
        if(dq.size() == 0) return -1;
        return dq.pollFirst();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueueImpl();
        maxQueue.add(3);
        maxQueue.add(4);
        maxQueue.add(1);
        maxQueue.add(2);
        System.out.println(maxQueue.pollMax());
        System.out.println(maxQueue.poll());
        System.out.println(maxQueue.pollMax());
        System.out.println(maxQueue.poll());
    }
}
