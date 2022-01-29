package Acwing;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class AC1904 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = n, pre = 0;
//        Stack<Integer> stk = new Stack<>();
//        while(n-- != 0) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            while(stk.size()!=0&&stk.peek() > y){
//                stk.pop();
//            }
//            stk.push(y);
//        }
//        System.out.println(stk.size());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer,Integer> map = new TreeMap<>((o1, o2) ->{
            return o2-o1;
        });
        int ans = n, pre = 0;;
        while(n-- != 0){
            int x = sc.nextInt();
            map.put(x,sc.nextInt());
            if(n==0){
                pre = map.get(x);
            }
        }
//        System.out.println(pre);
        for(int x:map.keySet()){

            if(map.get(x) > pre){
                ans--;
            }else{
                pre = map.get(x);
            }


        }
        System.out.println(ans);
    }
}
