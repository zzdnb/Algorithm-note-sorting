package leetcode;

import com.sun.javafx.binding.StringConstant;
import javafx.scene.shape.StrokeLineCap;

import java.util.Scanner;

public class AC7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(cal(x));
        System.out.println(Integer.MAX_VALUE);
    }

    public static int cal(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
        }
        StringBuilder s = null;
        if (flag) {
            s = new StringBuilder(String.valueOf(x).substring(1)).reverse();
        }else{
            s = new StringBuilder(String.valueOf(x)).reverse();
        }
        int idx = 0;
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i)!='0'){
                idx = i;
                break;
            }
        }
        if(flag){
            s = new StringBuilder("-"+s.substring(idx));
        }
        return Integer.valueOf(s.toString());
    }
}
