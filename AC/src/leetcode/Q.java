package leetcode;

import java.util.Scanner;

public class Q {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                String x = sc.next();
                arr2[i] = x.contains("/")?Integer.parseInt(x.substring(0,x.indexOf("/"))):Integer.parseInt(x);
                arr1[i] = x.contains("/")?Integer.parseInt(x.substring(x.indexOf("/")+1)):1;
            }
            int val = arr1[0];
            for(int i = 1; i < n; i++ ){
                val = val*arr1[i]/gcd(val,arr1[i]);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += arr2[i]*val/arr1[i];
            }
            if(res%val==0){
                System.out.println(res/val);

            }else{
                int x = gcd(res,val);
                if((float)res/val!=res/val){
                    if(Math.abs((float)res/val)<1){
                        System.out.println(res/x+"/"+val/x);
                    }else{

                        System.out.println(res/val+" "+res%val/x+"/"+val/x);
                    }
                }
            }


        }
        
        static int gcd(int a,int b){
            return b!=0?gcd(b,a%b):a;
        }

}
