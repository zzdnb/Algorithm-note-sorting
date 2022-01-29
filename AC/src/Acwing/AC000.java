package Acwing;

public class AC000 {
    public static void main(String[] args) {
        int cnt = 0;
        for(int i = (int)1e6; i < (int)1e7; i++){
            if (new StringBuilder(String.valueOf(i)).reverse().toString().equals(String.valueOf(i))){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
