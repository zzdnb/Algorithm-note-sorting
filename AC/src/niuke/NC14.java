package niuke;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class NC14 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        queue.add(pRoot);
        boolean flag = false;
        while(queue.size()!=0){
            int n = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                TreeNode p = queue.poll();
                tmp.add(p.val);
                if(p.left != null){
                    queue.add(p.left);
                }
                if(p.right!=null){
                    queue.add(p.right);
                }
            }
            System.out.println(flag);
            if(!flag){
                ans.add(tmp);
            }else{
                 for(int x:tmp){
                     stk.add(x);
                 }
                 tmp.clear();
                 while(stk.size()!=0){
                     tmp.add(stk.pop());
                 }
                 ans.add(tmp);
                 flag = !flag;
            }
        }
        return ans;
    }

}
