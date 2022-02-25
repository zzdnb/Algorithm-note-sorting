package Acwing;

import java.util.Scanner;

public class AC1123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        double ans = 0;
        while (sc.hasNext()) {
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x1 = sc.nextDouble(), y1 = sc.nextDouble();
            ans += Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))*2;

        }
        int cnt = (int)Math.round(ans/20000*60);
        System.out.printf("%d:%02d",cnt/60,cnt%60);
    }
}
