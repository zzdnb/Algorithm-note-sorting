package Acwing;

import java.util.Scanner;

public class AC4073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        String [] str = {"I hate that ","I love that "};
        String ans = "";
        for(int i = 0; i < n-1; i++){
            ans += str[i%2];
        }
        if(n-1%2==0){
            ans+="I hate it";
        }else{
            ans+="I love it";
        }

        System.out.println(ans);
    }
}
