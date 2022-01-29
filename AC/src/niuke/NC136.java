package niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NC136 {
    public static void main(String[] args) {

    }
    TreeNode dfs(int[]pre,int[] in, int pl,int pr,int il,int ir){
        if(pl >= pr){
            return null;
        }
        int d = map.get(pre[pl]);
        TreeNode root = new TreeNode(pre[pl]);
        root.left = dfs(pre,in,pl+1,d-il+pl,il,d-1);
        root.right = dfs(pre,in,d-il+1+pl,pr,d+1,ir);
        return root;
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        for(int i = 0; i < zhongxu.length; i++){
            map.put(zhongxu[i],i);
        }
        TreeNode root = dfs(xianxu,zhongxu,0,xianxu.length-1,0,zhongxu.length-1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer>list = new ArrayList<>();
        while(queue.size()!=0){
            int t = queue.size();
            for(int i = 0;i < t; i++){
                System.out.println(queue.peek().val);
                if(i == t-1){
                    list.add(queue.peek().val);
                }
                TreeNode tmp = queue.poll();
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }


        }
        int[]ans=new int[list.size()];
        int cnt = 0;
        for(int x:list){
            ans[cnt++]=x;
        }
        return ans;
    }
}
