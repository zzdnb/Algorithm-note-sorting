package Acwing;

import java.util.Scanner;

public class AC3547 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = n;  ; i++){
            int cnt = 0;
            int tmp  = i;
            while(tmp!=0){
                cnt += tmp%10;
                tmp = tmp/10;
            }

            if(cnt%4==0){
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
