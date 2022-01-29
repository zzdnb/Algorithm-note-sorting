package Acwing;

import java.util.Scanner;

public class AC4207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = 0;
        for(int i = 0,cnt = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            }else{
                if(cnt>0){
                    ans += 2;
                    cnt--;
                }
            }

        }
        System.out.println(ans);
    }
}
