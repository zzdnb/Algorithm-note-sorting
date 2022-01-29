package leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {
    public static int countHomogenous(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            tmp++;
            if (s.charAt(i) != s.charAt(i + 1)) {
                list.add(tmp);
                tmp = 0;
            }
        }
        list.add(tmp+1);
        long res = 0;
        for (int x : list) {
            res = (res + (long)x*(x+1)/2) % (int) (1e9 + 7);
        }
        return (int)res;

    }

//    public static int countHomogenous(String s) {
//        long count = 1, sum = 0;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == s.charAt(i - 1)) {
//                count++;
//            } else {
//                sum += count * (count + 1) / 2;
//                count = 1;
//            }
//        }
//        sum += count * (count + 1) / 2;
//        System.out.println(count);
//        System.out.println(sum);
//        return (int) (sum % 1000000007);
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine();
        System.out.println(countHomogenous(s));
    }
}

