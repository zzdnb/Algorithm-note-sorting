package niuke;
import java.util.Arrays;

import java.util.HashMap;

class Node {
    int key, val;
    Node left, right;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class NC93 {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int[] ans = new int[(int)1e5+10];
    int cnt = 0;
    int k = 0;
    void init() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;
    }

    int get(int key) {
        if (map.get(key) == null) {
            ans[cnt++] = -1;
            return -1;
        } else {
            Node p = map.get(key);
            remove(p);
            insert(p);
            ans[cnt++] = p.val;
            return p.val;
        }
    }

    void put(int key, int val) {
        if(map.containsKey(key)){
            Node p = map.get(key);
            p.val = val;
            remove(p);
            insert(p);
        }else{
            if(map.size() == k){
                Node p = tail.left;
                remove(p);
                map.remove(p.key);
            }
            Node t = new Node(key,val);
            insert(t);
            map.put(key,t);
        }
    }

    void insert(Node p) {
        p.right = head.right;
        p.right.left = p;
        p.left = head;
        head.right = p;
    }

    void remove(Node p) {
        p.left.right = p.right;
        p.right.left = p.left;
    }

    public int[] LRU(int[][] operators, int k) {
        // write code here
        this.k = k;
        init();
        for(int[]x:operators){
            if(x[0] == 1){
                put(x[1],x[2]);
                System.out.println(map.size()+" "+k);
            }else{
                get(x[1]);
            }
        }
        return Arrays.copyOfRange(ans,0,cnt);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NC93().LRU(new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}},3)));
    }
}
