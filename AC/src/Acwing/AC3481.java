package Acwing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AC3481 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] arr = new int[12];
        arr[0] = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        for(int i = 1; i <= 10; i++){
            arr[i] = arr[i-1]*i;

            HashSet<Integer> set1 = new HashSet<>();
            for(int x:set){
//                System.out.print(x+" ");
                set1.add(x+arr[i]);
            }
            System.out.println();
            set.addAll(set1);
            set.add(arr[i]);

        }

            while( (n = sc.nextInt()) != -1){
                    if(set.contains(n)){
                        System.out.println("YES");
                    }else{
                        System.out.println("No");
                    }
            }
    }
}
