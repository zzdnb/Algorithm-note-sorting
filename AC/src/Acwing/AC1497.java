package Acwing;

import java.util.Scanner;

public class AC1497 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(x <= m){
                sum += 1;

            }else{
                sum+=2;
            }
        }
        System.out.println(sum);
    }
}
