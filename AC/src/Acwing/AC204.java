package Acwing;

import java.util.Scanner;

/**
 * AC204
 */
public class AC204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a1 = sc.nextLong();
        long m1 = sc.nextLong();
        boolean flag = true;
        while (--n != 0) {
            long a2 = sc.nextLong();
            long m2 = sc.nextLong();

            long d = gcd(a1, a2);//最大公约数
            long t = a2 / d;//k1的取值范围
            k1 = k1 * (m2 - m1) / d;//k1*a1-k2*a2=m2-m1 ,k1的值对应m2-m1
            if ((m2 - m1) % d != 0) {
                flag = false;
                break;
            }//判断k1能不能取到整数
            k1 = (k1 % t + t) % t;//取k1+k（ a2 / d ）最小值
            //此时公式变形为x=( a1*k1+m1 )+( k*[a1,a2] ),k取任何整数，所以可以替换k1、k2、、
            m1 = a1 * k1 + m1;//维护m1=a1*k1+m1
            a1 = a1 / d * a2;//维护a1= [a1,a2] = a1*a2/d   []代表最小公倍数= 两个数乘积/两个数最大公约数
        }
        if (flag) {
            System.out.println((m1 % a1 + a1) % a1);//（m1 % a1的最小正整数）
        }
        //因为每次都是两个式子合并，而且每个x=k*a+m，而维护到最后一次的时候公式里的 m1=a1*k1+m1，a1=a1/d*a2
        //所以到最后会合并成一个式子：x= m1(%a1) = k*a1+m1  。这时候让%a1移到左边
        //变为m1 % a1 = x,此时结果就是取m1 % a1最小正整数
        else {
            System.out.println(-1);
        }


    }


    static long k1, k2;

    static long gcd(long a, long b) {
        if (b == 0) {
            k1 = 1;
            k2 = 0;
            return a;
        }
        long d = gcd(b, a % b);
        long tmp = k1;
        k1 = k2;
        k2 = tmp - a / b * k1;
        return d;
    }
}
