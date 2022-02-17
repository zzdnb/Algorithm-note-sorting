package niuke;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3)));
    }
    public static int[] merge (int[] A, int m, int[] B, int n) {
        // write code here
        int i = m-1,j = n-1,sum = m+n-1;
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                A[sum--] = A[i--];
            }else{
                A[sum--] = B[j--];
            }
        }
        while(i >= 0){
            A[sum--] = A[i--];
        }
        while(j >= 0){
            A[sum--] = B[j--];
        }
        return A;
    }
}
