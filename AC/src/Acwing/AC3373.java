package Acwing;

import java.math.BigInteger;
import java.util.Scanner;

public class AC3373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        BigInteger b = new BigInteger(s);
        BigInteger div = new BigInteger("2");
        StringBuilder sb = new StringBuilder();
        if("0".equals(s)){
            sb.append(0);
        }
        while(!b.equals(BigInteger.ZERO)){
            BigInteger tmp = b.mod(div);
            sb.append(tmp);
            b = b.divide(div);
        }
        System.out.println(sb.reverse());
    }

}
