package niuke;


import java.util.ArrayList;

public class NC112 {
    ArrayList<Integer> list = new ArrayList<>();
    public String solve (int M, int N) {

        // write code here
        StringBuilder sb = new StringBuilder();
        if(M == 0){
            return "0";
        }
        boolean flag = false;
        if(M < 0){
            flag = true;
            M = Math.abs(M);
        }
        while(M!=0){
            if(M%N < 10){
                sb.append(M%N);
            }else{
                sb.append((char)(M%N-10+'A'));
            }
            M /=N;
        }
        if (flag){
            return "-"+sb.reverse().toString();
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new NC112().solve(-9,16));
    }
}
