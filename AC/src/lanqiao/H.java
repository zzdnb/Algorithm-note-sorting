package lanqiao;

import java.math.BigInteger;
import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        BigInteger n = new BigInteger(s);
        BigInteger m = new BigInteger("2");
        while(!n.equals(BigInteger.ZERO)){
            System.out.print(n);
            n = n.divide(m);
        }

    }
}
