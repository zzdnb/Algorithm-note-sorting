package Acwing;

import java.util.PriorityQueue;
import java.util.Scanner;

public class AC906 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[][] = new int[n][2];
        //按照左端点排序
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            queue.offer(arr[i]);
        }
        // -1 1  2 4 3 5
        int [] tmp = queue.poll();
        int l = tmp[0];
        int r = tmp[1];
        int max_r = tmp[1];

        int ans = 1;
        while(queue.size()!=0){
            tmp = queue.peek();

            if(tmp[0] >= max_r){
                l = tmp[0];
                r = tmp[1];
                max_r = Math.max(max_r,tmp[1]);
                ans++;
            }else{
                if(tmp[1] >= max_r){
                    l = tmp[0];
                    r = tmp[1];

                    ans++;
                }
            }
            System.out.println(tmp[0]+" "+tmp[1]);
            System.out.println(l+" "+r+" "+ans);
            queue.poll();
        }

       System.out.println(ans);
    }

}
