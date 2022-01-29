package niuke;

import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int f = sc.nextInt();
        int k = sc.nextInt();
        int cnt = m+f;
        int sum = m+f;
        char[] ch = new char[m+f];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(cnt != m){
            index = (index+k%cnt)%sum;
            ch[index] = 'F';
            cnt --;
            System.out.println(index);
        }
        if(ch[0]!='F'){
            for(int i = 1; i <m+f; i++){
                if(ch[i]=='F'){
                    sb.append('F');
                }else{
                    sb.append('M');
                }
            }
            sb.append('M');
        }else{
            for(int i = 1; i <m+f; i++){
                if(ch[i]=='F'){
                    sb.append('F');
                }else{
                    sb.append('M');
                }
            }
            sb.append('F');
        }
        System.out.println(sb.toString());
    }
}