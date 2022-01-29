package Acwing;

import java.util.Scanner;

public class AC4076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i)=='1'){
                res += 10;
                continue;
            }
            res += s.charAt(i)-'0';
        }
        System.out.println(res);
    }
}
