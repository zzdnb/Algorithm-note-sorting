package Acwing;

import java.util.Scanner;

public class AC4300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        if(x >= y){
            System.out.println(x-y);
            return;
        }

        int cnt = 0;
        while(x!=y){
            if(y%2 != 0){
                y = y+1;
                cnt++;
            }else{
                y = y/2;
                cnt++;
            }
            if(x > y){
                cnt += x-y;
                y = x;
            }
        }
        System.out.println(cnt);
    }
}
