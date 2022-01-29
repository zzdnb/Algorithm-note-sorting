package lanqiao;

import java.util.HashMap;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        String s = "0";
        if(n!=0){
            s="";
        }
        while (n != 0) {
            int x = n % 16;
            if (x > 9 && x < 16) {
                s = map.get(x) + s;
            } else {
                s = x + s;
            }
            n /= 16;
        }


            System.out.println(s);

    }
}
