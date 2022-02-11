package luogu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("[a-z]+");
        HashSet<String> set = new HashSet<>();
        for (String x : s) {
            if (!x.equals("")) {
                x = x.replaceFirst("^0*", "");
                set.add(x);
            }
        }
        System.out.println(set.size());


    }
}
class Solution {
    public String evaluate(String s, List<ArrayList<String>> knowledge) {
        String ss = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)!='('){
                ss += s.charAt(i);
                continue;
            }
            String sss = "";
            int j = i;
            while(j < s.length()&&s.charAt(j)!=')'){
                sss +=s.charAt(j);
                j++;
            }
            for(int k = 0; k < knowledge.size(); k++){
                if(knowledge.get(i).get(0)==sss){
                    ss +=knowledge.get(i).get(1);
                }
            }
            i = j+1;
        }
        return ss;
    }
}