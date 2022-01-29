package Acwing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class AC3489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();

            String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
            String[] day = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            int[] mm = {31,28,31,30,31,30,31,31,30,31,30,31};
            int m = 0;
            for (int i = 0; i < 12; i++) {
                if (s2.equals(month[i])) {
                    m = i ;
                }
            }
            int y = Integer.valueOf(s3);
            int res = 0;
            for (int i = 1; i < y; i++) {
                if (i % 4 == 0 && i % 100 != 0 ||( i % 400 == 0)) {
                    res += 366;
                } else {
                    res += 365;
                }
            }
            if (y % 4 == 0 && y % 100 != 0 && y % 400 == 0) {
                mm[1] = 29;
            }
            for (int i = 0; i < m; i++) {
                res += mm[i];
            }
            res += Integer.valueOf(s1);
            System.out.println(res);
            System.out.println(day[res%7]);

        }

    }
}


class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
            HashMap<String, Integer> map = new HashMap<>();
            map.put("January",1);
            map.put("February",2);
            map.put("March",3);
            map.put("April",4);
            map.put("May",5);
            map.put("June",6);
            map.put("July",7);
            map.put("August",8);
            map.put("September",9);
            map.put("October",10);
            map.put("November",11);
            map.put("December",12);


            String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
            String d = sc.next();
            String m = sc.next();
            String y = sc.next();

            int days = 0;
            for(int year = 1; year < Integer.parseInt(y); year++){
                for(int i = 1; i <= 12; i++){
                    days += months[i];
                    if(i == 2){
                        if(year % 100 != 0 && year % 4 == 0 || year % 400 == 0)
                            days++;
                    }
                }
            }

            for (int i = 1; i < map.get(m) ; i++) {
                days += months[i];
                if(i == 2){
                    int x = Integer.parseInt(y);
                    if(x % 100 != 0 && x % 4 == 0 || x % 400 == 0)
                        days++;
                }
            }
            days += Integer.parseInt(d) - 1;
            System.out.println(days);
            System.out.println(week[days % 7]);
        }

    }
}

