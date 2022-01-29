package lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String target = read.readLine().toLowerCase();
        String []s = read.readLine().split(" ");
        ArrayList<String> list  = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int [] arr = new int[1000005];

        for(int i = 0; i < s.length; i++){
            list.add(s[i].toLowerCase());
        }
        for(int i = 1; i <= s.length; i++){
            arr[i] = arr[i-1]+ s[i-1].length()+1;
        }
        for(String ss :list){
            map.put(ss,map.getOrDefault(ss,0)+1);
        }
        if(list.indexOf(target)<0){
            System.out.println(-1);
            return;
        }else {

            System.out.println(map.get(target)+" "+arr[list.indexOf(target)]);
        }
    }
}
