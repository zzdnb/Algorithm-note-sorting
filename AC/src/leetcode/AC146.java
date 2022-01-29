package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class AC146 {
    HashMap<Integer, Integer> map = new HashMap<>();
    static int N = 50000;
    static int[] l = new int[N], r = new int[N], e = new int[N];
    static int idx = 0;
    int capacity = 0,cnt = 0;


    static void init() {
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    static void add(int a, int b) {
        e[idx] = b;
        r[idx] = r[a];
        l[idx] = a;
        l[r[a]] = idx;
        r[a] = idx++;
    }

    static void delete(int a) {
        l[r[a]] = l[a];
        r[l[a]] = r[a];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


    }

    public AC146(int capacity) {
        init();
        this.capacity = capacity;

    }

    public int get(int key) {

        if (map.get(key) ==null||map.get(key)==-1){
            return -1;
        }

        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);

        cnt++;
        if(cnt > capacity){

        }
    }

}
