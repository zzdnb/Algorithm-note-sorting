package Acwing;

import java.util.Scanner;

public class AC1453 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            while(sb.length()>0&&k>0&&s.charAt(i)-'0'<sb.charAt(sb.length()-1)-'0'){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            if(sb.length()==0&&s.charAt(i)=='0'){
                continue;
            }
            sb.append(s.charAt(i));
        }
        while (k>0&&sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        if(sb.length()==0){
            System.out.println("0");
        }else{
            System.out.println(sb.toString());
        }
    }
}
