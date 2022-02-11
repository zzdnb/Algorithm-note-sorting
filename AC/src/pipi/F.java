package pipi;

import java.io.IOException;
import java.util.Scanner;

public class F {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int res = 0;
        String ss = null;
        while (sc.hasNext()) {
            String s = sc.next();
            int flag = 0;
            if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
                res++;
                sb.append(s.charAt(0));
            }else{
                res = 0;
                sb = new StringBuilder();
            }
            if(res >1){

            }
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLowerCase(s.charAt(i)) && !Character.isUpperCase(s.charAt(i))) {
                    flag = i;
                    break;
                }
            }
            sb.append(s.substring(flag));
        }
    }

}


