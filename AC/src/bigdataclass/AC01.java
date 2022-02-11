package bigdataclass;

public class AC01 {
    //斐波那契数列
    public static void main(String[] args) {
        int a = 1,b = 1,c = 0;
        for(int i = 3; i <= 20; i++){
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
