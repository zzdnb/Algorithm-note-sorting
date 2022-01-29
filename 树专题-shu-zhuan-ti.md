---
title: 树专题
date: 2022-01-07 12:19:14.714
updated: 2022-01-28 20:03:38.853
url: /archives/shu-zhuan-ti
categories: 算法
tags: 
---

[TOC]()
## AcWing 37. 树的子结构
二叉树，递归) O(nm)O(nm)
代码分为两个部分：

遍历树A中的所有非空节点R；
判断树A中以R为根节点的子树是不是包含和树B一样的结构，且我们从根节点开始匹配；
对于第一部分，我们直接递归遍历树A即可，遇到非空节点后，就进行第二部分的判断。

对于第二部分，我们同时从根节点开始遍历两棵子树：

如果树B中的节点为空，则表示当前分支是匹配的，返回true；
如果树A中的节点为空，但树B中的节点不为空，则说明不匹配，返回false；
如果两个节点都不为空，但数值不同，则说明不匹配，返回false；
否则说明当前这个点是匹配的，然后递归判断左子树和右子树是否分别匹配即可；
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        if(pRoot1 == null || pRoot2 == null){
            return false;
        }
        if(isPart(pRoot1,pRoot2)){
            return true;
        }
        return hasSubtree(pRoot1.left,pRoot2) || hasSubtree(pRoot1.right,pRoot2);
    }
    boolean isPart(TreeNode p1, TreeNode p2){
        if(p2 == null){
            return true;
        }
        if(p1 == null || p1.val != p2.val){
            return false;
        }
        return isPart(p1.left,p2.left) &&isPart(p1.right,p2.right);
    }
}
```
## NC102 在二叉树中找到两个节点的最近公共祖先
```java
import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root == null){
            return 0;
        }
        if( root.val == o1 || root.val == o2){
            return root.val;
        }
        int l = lowestCommonAncestor(root.left,o1,o2);
        int r = lowestCommonAncestor(root.right,o1,o2);
        if(l == 0){
            return r;
        }
        if(r == 0){
            return l;
        }
        return root.val;
    }
}
```
## NC12 重建二叉树
```
import java.util.*;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution { 
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        int n = vin.length;
        for(int i = 0; i < n; i++){
            map.put(vin[i],i);
        }
        return dfs(pre,vin,0,n-1,0,n-1);
    }

    TreeNode dfs(int[] preorder, int[] inorder,int pl,int pr,int il,int ir){
        if(pl>pr){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int k = map.get(preorder[pl]);
        root.left = dfs(preorder,inorder,pl+1,k-il+pl,il,k-1);
        root.right = dfs(preorder,inorder,k-il+pl+1,pr,k+1,ir);
        return root;
    }
}
```
## LeetCode98.验证二叉搜索树
## LeetCode99.恢复二叉搜索树（Morris遍历）
## LeetCode100.相同的树
## LeetCode101.对称二叉树
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isTrue(root,root);
    }
    boolean isTrue(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 ==null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        }
        if(r1.val != r2.val){
            return false;
        }
        return isTrue(r1.left,r2.right)&&isTrue(r1.right,r2.left);
    }
    
}
```
## 剑指38
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mirror(TreeNode root) {
        if(root == null){
            return;
        }
        root = get(root);
    }
    TreeNode get(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode l = get(root.left);
        TreeNode r = get(root.right);
        root.left = r;
        root.right = l;
        return root;
        
        
    }
}
```
## LeetCode102.二叉树的层序遍历
## LeetCode107.二叉树的层次遍历Ⅱ
## LeetCode103.二叉树的锯齿形层次遍历
## LeetCode104.二叉树的最大深度
## LeetCode105.从前序和中序遍历序列构造二叉树
## LeetCode106.从中序和后序遍历序列构造二叉树
## LeetCode108.将有序数组转换为二叉搜索树
## LeetCode109.有序链表转换二叉搜索树
## LeetCode110.平衡二叉树
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int getH(TreeNode root){
        if(root == null){
            return 0;  
        }
        return Math.max(getH(root.left),getH(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        
        return l && r && (Math.abs(getH(root.left)-getH(root.right)) <= 1);
    }
}
```
## LeetCode111.二叉树的最小深度
## LeetCode112.路径总和
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean dfs(TreeNode root, int targetSum,int sum){
        if(root == null){
            return false;
        }
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                return true;
            }
        }
        return dfs(root.left,targetSum,sum)||dfs(root.right,targetSum,sum);
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum,0);

    }
}
```
## LeetCode113.路径总和Ⅱ
由于这个path是共享的，所以你需要去回溯，不去影响其他的状态。
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    void dfs(TreeNode root,int targetSum,int sum){
        if(root == null){
            return;
        }
        path.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                ArrayList<Integer> list = new ArrayList<>();
                list.addAll(path);
                ans.add(list);
            }
        }
        dfs(root.left,targetSum,sum);
        dfs(root.right,targetSum,sum);
        path.remove(path.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum,0);
        return ans;
    }
}
```
## LeetCode114.二叉树展开为链表
## LeetCode116.填充每个节点的下一个右侧节点指针
## LeetCode117.填充每个节点的下一个右侧节点指针Ⅱ
## NC5 二叉树根节点到叶子节点的所有路径和
```java
import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @return int整型
     */
    int sum = 0;
    void dfs(TreeNode root,int u){
        if(root == null){
            return;
        }
        u= u*10+root.val;
        if(root.left == null&&root.right == null){
            sum += u;
            return ;
        }
        dfs(root.left,u);
        dfs(root.right,u);
        
    }
    public int sumNumbers (TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        dfs(root,0);
        return sum;
    }
}
```
## LeetCode124.二叉树中的最大路径和
先去求每一个点为根节点的往下延伸的最大路径和，然后再去求每个根节点与左右联合起来的最大值。
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = -(int)1e9;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.max(0,dfs(root.left)), r = Math.max(0,dfs(root.right));
        ans = Math.max(ans,root.val+l+r);
        return root.val+Math.max(l,r);
    }
}
```
## LeetCode129.求根到叶子节点数字之和
## LeetCode144.二叉树的前序遍历
## LeetCode145.二叉树的后序遍历
## LeetCode173.二叉搜索树迭代器
## LeetCode222.完全二叉树的节点个数
## LeetCode226.翻转二叉树
## LeetCode230.二叉搜索树中第K小的元素
## LeetCode297.二叉树的序列化与反序列化
## LeetCode352.将数据流变为多个不相交区间（平衡二叉树TreeSet）
## LeetCode404.左叶子之和
## LeetCode429.N叉树的层序遍历
## LeetCode449.序列化和反序列化二叉搜索树
## LeetCode450.删除二叉搜索树中的节点
## LeetCode501.二叉搜索树中的众数
## LeetCode513.找树左下角的值（BFS）
## LeetCode515.在每个树行中找最大值（BFS）
## LeetCode1609.奇偶树（BFS）

