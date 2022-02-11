package luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader((System.in)));
        String [] s = read.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        char [][]arr = new char[105][105];
        for(int i = 1 ;i <=n;i++){
            char[] ch = read.readLine().toCharArray();
            for(int j = 1; j <=m;j++){
                arr[i][j] = ch[j-1];
            }
        }

        for(int i = 1 ; i <= n;i++){
            for(int j = 1; j <=m;j++){
                int temp = 0;
                if(arr[i][j]!='*'){
                    if(arr[i-1][j-1]=='*'){
                        temp++;
                    } if(arr[i-1][j+1]=='*'){
                        temp++;
                    } if(arr[i+1][j+1]=='*'){
                        temp++;
                    } if(arr[i+1][j-1]=='*'){
                        temp++;
                    } if(arr[i+1][j]=='*'){
                        temp++;
                    } if(arr[i-1][j]=='*'){
                        temp++;
                    } if(arr[i][j+1]=='*'){
                        temp++;
                    } if(arr[i][j-1]=='*'){
                        temp++;
                    }
                    arr[i][j] = (char)('0'+temp);
                }
            }
        }
        for(int i = 1 ; i <= n;i++){
            for(int j = 1; j <=m;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
