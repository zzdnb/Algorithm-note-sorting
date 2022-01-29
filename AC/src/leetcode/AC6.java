package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AC6 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        //考虑特殊情况，就是当是一行的时候，输出一样

        int min = Math.min(s.length(), numRows);
        for (int i = 0; i < min; i++) {
            list.add(new StringBuilder());
        }
        int idx = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            //这个放在前面的话，在添加的时候会首先添加
            if (idx == 0 || idx == numRows - 1) {
                flag = !flag;
                list.get(idx).append(s.charAt(i));
            } else {
                list.get(idx).append(s.charAt(i));
            }
            idx += flag ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder x : list) {
            sb.append(x);
        }
        return sb.toString();
    }

}
