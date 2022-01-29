package lanqiao;

import java.util.HashMap;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
        long res = 0;
        for(int i = s.length()-1; i >=0;i--){
            char a = s.charAt(i);
            if(a>='A'&&a<='F'){
                res +=map.get(a)*Math.pow(16,s.length()-1-i);
            }else{
                res +=(s.charAt(i)-'0')*Math.pow(16,s.length()-1-i);
            }
        }
        System.out.println(res);
    }
}
