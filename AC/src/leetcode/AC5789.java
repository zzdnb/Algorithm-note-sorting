package leetcode;

import java.util.Scanner;

public class AC5789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(numberOfRounds("23:48",
                "23:16"));
    }

    public static int numberOfRounds(String startTime, String finishTime) {

        String tmp1 = startTime.substring(0, 2);
        if (startTime.charAt(0) == '0') {
        tmp1 = startTime.substring(1, 2);
    }

    String tmp2 = finishTime.substring(0, 2);
        if (finishTime.charAt(0) == '0') {
        tmp2 = finishTime.substring(1, 2);
    }

    String tmp3 = startTime.substring(3);
        if (startTime.charAt(3) == '0') {
        tmp3 = startTime.substring(3);
    }

    String tmp4 = finishTime.substring(3);
        if (finishTime.charAt(3) == '0') {
        tmp4 = finishTime.substring(3);
    }

    int x = Integer.valueOf(tmp1) * 60 + Integer.valueOf(tmp3);
    int y = Integer.valueOf(tmp2) * 60 + Integer.valueOf(tmp4);
        System.out.println(x + " " + y);
        if (x < y) {
        int cnt = 0;
        for (int i = x; i <= y; i++) {
            if (i % 15 == 0) {
                cnt++;
            }
        }
        return cnt - 1;
    } else {
        int cnt = 0;
        if(y % 15 != 0){
            y = y - (y%15);
        }
        for (int i = 0; i <= 60 * 24 - x+y ; i++) {
            if (i % 15 == 0) {
                cnt++;
            }
        }
        return cnt-1 ;
    }
}

}
