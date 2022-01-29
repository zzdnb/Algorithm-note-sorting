package Acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AC3483 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            int[] arr = new int[6];
            for(int j = 0; j <= 4; i++){
                if(((i >> j )& 1) !=0){
                    arr[j]++;
                }
            }
            for(int j = 6; j >= 0; j++){
                if (arr[j]==1){

                }
            }

        }
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[16];
            for(int i = 0; i <= 15; i++){
                if(((n >> i )& 1) !=0){
                    arr[i]++;
                }
            }

            for (int i = 0; i < 16 ; i++){
                System.out.println(arr[i]);
            }
        }
    }
}
