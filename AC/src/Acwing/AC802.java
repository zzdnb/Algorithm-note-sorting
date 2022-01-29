package Acwing;

import java.util.*;

public class AC802 {
        static int[] sum = new int[(int)3e5+10];
        static TreeMap<Integer,Integer> map = new TreeMap<>();
        static ArrayList<Node1> query = new ArrayList<>();
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            for(int i = 0; i < n; i++){
                int x = sc.nextInt();
                int c = sc.nextInt();
                map.put(x,map.getOrDefault(x,0)+c);
            }
            for (int i = 0; i < m; i++){
                int x = sc.nextInt();
                int c = sc.nextInt();
                map.put(x,map.getOrDefault(x,0));
                map.put(c,map.getOrDefault(c,0));
                query.add(new Node1(x,c));
            }
            Object[] obj = map.keySet().toArray();
            Integer[] index = Arrays.copyOfRange(obj,0,obj.length,Integer[].class);
            int k = 1;
            for(int x: map.values()){
                sum[k] = sum[k-1] + x;
                k++;
            }
            for(Node1 node: query){
                int x1 = queryIndex(index,node.first);
                int x2 = queryIndex(index,node.second);
                System.out.println(x1 +" "+x2);
                System.out.println(sum[x2]-sum[x1-1]);
            }
        }
        static int queryIndex(Integer[] index,int x){
            int l = 0, r = index.length-1;
            while(l < r){
                int mid = (l+r) >> 1;
                if(index[mid] >= x){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return r+1;
        }
    }


class Node1{
    int first;
    int second;
    Node1(int first,int second){
        this.first = first;
        this.second = second;
    }
}