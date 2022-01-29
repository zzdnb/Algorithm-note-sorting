package Acwing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AC803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[2];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            list.add(arr);
//            System.out.println("dss");
        }

        list.sort(((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        ArrayList res = new ArrayList<>();
        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        for(int[] a:list){
//             System.out.println(Arrays.toString(a));
            if(a[0] > r){
                if(l!=Integer.MIN_VALUE){
                    res.add(new int[]{l,r});
                }
                l = a[0];
                r = a[1];
            }else{
                r = Math.max(r,a[1]);
            }
        }
        if(l != Integer.MIN_VALUE){
            res.add(new int[]{l,r});
        }
        System.out.println(res.size());

    }
}
//public class AC803 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] arr = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//        Arrays.sort(arr,(o1,o2)->{
//            return o1[0]-o2[0];
//        });
//        int res = 1;
//        int l = arr[0][0], r = arr[0][1];
//        for(int i = 1; i < n; i++){
//            if(arr[i][0] <= r){
//                r = Math.max(arr[i][1],r);
//            }else{
//                res++;
//                l = arr[i][0];
//                r = arr[i][1];
//            }
//        }
//        System.out.println(res);
//    }
//}
