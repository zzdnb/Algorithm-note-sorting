package luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E_2021 {
    static int n,k;

    static List<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i <= k; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            list.add(tmp);
        }
        for(int i = 0; i < n; i++){
            int s = sc.nextInt();
            if(s == 1){
                int p = sc.nextInt();
                while(p-- != 0){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                        list.get(x).add(y);

                }

            }else{
                int x = sc.nextInt();
                int y1 = sc.nextInt();
                int y2 = sc.nextInt();
                if(list.get(x)==null){
                    System.out.println(0);
                }else{
                    int cnt = 0;
                    for(int xx:list.get(x)){
                        if (xx>=y1&& xx<=y2){
                            cnt++;
                        }
                    }
                    System.out.println(cnt);
                }

            }

        }
    }
}



