package Acwing;

import java.util.Scanner;

public class TL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = n*2+1;
        char[][] ch = new char[x][x];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                if(i == j || i+j == x-1){
                    ch[i][j] = '+';
                }
            }
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        ch = new char[x][x];
        for(int i = 0; i <= x/2; i++){
            for(int j = 0; j < x; j++){
                if(i == j || i+j == x-1){
                    ch[i][j] = '+';
                }
            }
        }

        for(int i = x/2+1; i < x; i++){
            ch[i][x/2] = '+';
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        ch = new char[x][x];

        for(int i = 0; i < x-1; i++){
            ch[0][i] = '+';
        }
        for(int i = 1; i < x-1; i++){
            ch[i][0] = '+';
            ch[i][x-1] = '+';
        }
        for(int i = 0; i < x-1; i++){
            ch[x-1][i] = '+';
        }
        for(int i = 0; i < x; i++){
            for(int j = 0; j < x; j++){
                System.out.print(ch[i][j]);
            }
            System.out.println();
        }
    }
}
