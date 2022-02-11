package luogu;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[] arr = new int[25];
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            arr[a]++;
        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            arr[a]++;
        }
        int ans = 0;
        for(int i = 0; i < 25; i++){
            if(arr[i]>1){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
