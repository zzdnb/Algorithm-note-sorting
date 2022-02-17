package Acwing;

import java.util.Scanner;

public class AC4299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        boolean flag = false;
        for(int i =0 ; i < n; i++){

            int cnt1 = 0,cnt2 = 0;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(arr[j][0] < 0){
                    cnt1++;
                }else{
                    cnt2++;
                }

            }
            if(cnt1 == n-1 || cnt2 == n-1){

                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
