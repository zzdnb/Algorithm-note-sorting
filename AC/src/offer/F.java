package offer;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(cal(s));

    }
    public static int cal(String s){
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += (s.charAt(s.length()-1-i)-'0')*Math.pow(10,i);
        }
        return res;
    }
}
