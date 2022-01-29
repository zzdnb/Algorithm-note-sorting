package Acwing;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int res = 1;
        while(k != 0){
            if((k & 1) == 1){
                res++;
            }
            k = k >> 1;
        }
        System.out.println(res);

    }


}
