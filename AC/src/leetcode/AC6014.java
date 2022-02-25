package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

public class AC6014 {
    public static void main(String[] args) {
        System.out.println(new AC6014().repeatLimitedString("cczazcc", 3));

    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int n = s.length();
        int[] arr = new int[26];
        for (char c:s.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int pre = -1,rep = 0;
        for (int j =0;j <s.length();j++){
            for (int i = 25; i >= 0; i--) {
                if(arr[i] != 0 && (pre != i ||rep < repeatLimit)){
                    arr[i]--;
                    if(pre == i){
                        rep++;
                    }else{
                        pre = i;rep = 1;
                    }
                    sb.append((char)('a'+i));
                    break;
                }

            }
        }
        return sb.toString();

    }
}
