package pdf;

public class B {
    public static void main(String[] args) {
        System.out.println((int)(Math.random()*5+1));
        System.out.println(gcd(80,60));
    }
    public static int gcd(int m, int n){
        return n==0?m:gcd(n,m%n);
    }
}
