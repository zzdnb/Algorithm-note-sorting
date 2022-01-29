package Acwing;

import java.util.Scanner;

public class AC4206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt1 = 0;
        int cnt2 = 0;
        String s  = sc.next();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '4'){
                cnt1++;
            }
            if(s.charAt(i) == '7'){
                cnt2++;
            }
        }
        if(cnt1+cnt2 == 4 || cnt1 + cnt2 == 7){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
