import java.util.Scanner;
import java.util.Stack;

public class AC830 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                while(!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(arr[stack.peek()]);
                }
                stack.push(i);
            }
    }
}
