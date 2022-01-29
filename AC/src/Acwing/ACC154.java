package Acwing;

import java.util.*;
public class ACC154{
    static int[] arr = new int[100010];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Deque<Integer> min = new LinkedList<>();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            while(!min.isEmpty()&&min.peekFirst()<i-k+1){
                min.pollFirst();
            }
            while(!min.isEmpty()&&arr[i] < min.peekLast()){
                min.pollLast();
            }
            min.add(i);
            if(i>=k-1){
                System.out.print(arr[min.peekFirst()]+" ");
            }
        }
        System.out.println();
        Deque<Integer> max = new LinkedList<>();
        for(int i = 0; i < n; i++){
            while(!max.isEmpty()&&max.peekFirst()<i-k+1){
                max.pollFirst();
            }
            while(!max.isEmpty()&&arr[i] > max.peekLast()){
                max.pollLast();
            }
            max.add(i);
            if(i>=k-1){
                System.out.print(arr[max.peekFirst()]+" ");
            }
        }
    }
}