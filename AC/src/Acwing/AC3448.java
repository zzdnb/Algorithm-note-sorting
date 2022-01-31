package Acwing;

import java.util.ArrayList;
import java.util.Scanner;

public class AC3448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = "",s2 = "";
        while(sc.hasNext()){
            s1 = sc.next();
            s2 = sc.next();
            if(s1.equals( "0") && s2.equals("0")){
                break;
            }
            ArrayList<Character> l1 = new ArrayList<>();
            ArrayList<Character> l2 = new ArrayList<>();
            for(int i = s1.length()-1; i >= 0; i--){
                l1.add(s1.charAt(i));
            }
            for(int i = s2.length()-1; i >= 0; i--){
                l2.add(s2.charAt(i));
            }
            int t = 0,cnt = 0,i = 0;
            while(i < l1.size() || i < l2.size() || t!= 0){
                if(i < l1.size()){
                    t+=l1.get(i)-'0';
                }
                if(i < l2.size()){
                    t+=l2.get(i)-'0';
                }
                t = t/10;
                cnt += t;
                i++;
            }
            if(cnt == 0){
                System.out.println("No carry operation.");
            }else if (cnt == 1){
                System.out.println("1 carry operation.");
            }else{
                System.out.println(cnt+" carry operations.");
            }
        }
    }
}
