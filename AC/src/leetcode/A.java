package leetcode;

import java.util.Scanner;

public class A {
    public static String convertToBase7(int num) {
        boolean flag = false;
        if(num<0){
            flag = true;
            num = Math.abs(num);
        }
        String s = "";
        while(num!=0){
            s = String.valueOf(num%7)+s;
            num  = num/7;
        }
        if(flag){
            s = "-"+s;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(convertToBase7(n));
    }
}