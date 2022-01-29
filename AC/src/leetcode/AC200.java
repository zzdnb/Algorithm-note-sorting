//package leetcode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class AC200 {
//
//    int n, m;
//    boolean st[][];
//    int[] d;
//    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//         d = new int[numCourses];
//        for(int[] x:prerequisites){
//            if(!map.containsKey(x[0])){
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(x[1]);
//                map.put(x[0],list);
//            }else{
//                map.get(x[0]).add(x[1]);
//            }
//            d[x[1]]++;
//        }
//        boolean ans = topsort(numCourses);
//    }
//    boolean topsort(int numCourses){
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i = 0; i < numCourses; i++){
//            if(d[i]==0){
//                queue.add(i);
//            }
//        }
//        int cnt = 0;
//        while(queue.isEmpty()){
//            cnt++;
//            int u = queue.poll();
//            if(map.containsKey(u)){
//                for(int x:map.get(u)){
//                    if(--d[x]==0){
//                        queue.add(x);
//                    }
//                }
//            }
//        }   return false
//    }
//
//
//
//}
//
