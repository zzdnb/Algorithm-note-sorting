---
title: 剑指OFFER
date: 2021-12-29 19:52:43.652
updated: 2022-01-18 08:35:25.32
url: /archives/剑指offer
categories: 算法
tags: 
---

## 1. 找出数组中重复的数字
> 解题思路：由于数组中出现多个重复的数字，如果把对应下标的数字放到对应的位置上，出现多个数字对应一个下标，如果出现对应的nums[i]!=i的话，证明该数字出现了多次。
时间复杂度分析：O(n)，由于一个数最多会被交换n-1次
> 本题还可以采用数组或者哈希表来判重，时间和空间复杂度不能达到最优
```java
// nums[0] nums[2] 5 3 2 nums[0] = 5 nums[5] = 2 
//
class Solution {
  
    public int duplicateInArray(int[] nums) {
        int n = nums.length;
        for(int x:nums){
            if(x<0||x>=n){
                return -1;
            }
        }
        for (int i = 0; i < n; i ++ ) {
        
            // 如果没有重复元素，经过这一步操作，0位置将会存储0， i位置将会存储i
            while (nums[nums[i]] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            // 如果有重复元素 将会导致 因为有两个相同的数 但是只有一个位置 所以位置和值不能一一对应
            if (nums[i] != i) return nums[i];
        }
        // 找不到重复的数就返回-1 
        return -1;

    }
}
```
##  2.不修改数组找出重复的数字
```java

class Solution {
    public int duplicateInArray(int[] nums) {
        int N = 1010;
        boolean [] flag = new boolean[N];
        for(int x:nums){
            if(!flag[x]){
                flag[x] = true;
            }else{
                return x;
            }
        }
        return 1;
    }
}
```
> 本题采用时间复杂度O(n)加空间复杂度O(n)的方法：开一个bool数组，遍历即可

>还可用采用时间复杂度O（nlogn）的复杂度，空间复杂度为O(1)来解决这个问题。    
本题使用O(nlogn)的复杂度
    根据鹊巢原理可得：1-n范围内有n+1个数，必然you重复元素，
    因此将数组划分1到n/2，n/2+1到n的范围，然后统计数组中的元素个数，不停缩小区间，
    如果统计的元素个数大于区间长度的话，答案就在l到mid的区间里，否则就在mid+1到r的范围内
![image.png](/upload/2021/12/image-e1e947e623774f4db4484845c8fed004.png)
```java
class Solution {
    //本题使用O(nlogn)的复杂度
    //根据鹊巢原理可得：1-n范围内有n+1个数，必然you重复元素，
    //因此将数组划分1到n/2，n/2+1到n的范围，然后统计数组中的元素个数，不停缩小区间，
    //如果统计的元素个数大于区间长度的话，答案就在l到mid的区间里，否则就在mid+1到r的范围内
    public int duplicateInArray(int[] nums) {
        int l = 1,r = nums.length-1;
        while(l < r){
            int mid = (l+r)>>1;
            //统计该区间里的元素个数
            int cnt = 0;
            for(int x:nums){
                if(x>=l&&x<=mid){
                    cnt++;
                }
            }
            if(cnt > mid - l + 1){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }
}
```
## 3. 二维数组中的查找
>解题思路：本题要找目标元素，由于从左到右递增，从上到下递增，我们可以利用这个性质，把握边界，由于左上角元素较为特殊，一行中最大，一列中最小，所以，当比它大往下移，比它小往左移，最后把握边界位置，输出结果。
```java
class Solution {
    public boolean searchArray(int[][] arr, int target) {
        if(arr.length == 0){
            return false;
        }
        int n = arr.length, m = arr[0].length;
        int i = 0,j = m-1;
        while(true){
            while(j>=0 && arr[i][j] > target){
                j--;
            }
            if(j < 0){
                return false;
            }
            if(arr[i][j] == target){
                return true;
            }
            while(i < n && arr[i][j] < target){
                i++;
            }
            if(i >= n){
                return false;
            }
            if(arr[i][j] == target){
                return true;
            }
        }
        
    }
}
```
## 4.用两个栈实现队列
> 主要实现思路：栈的特点是先进后出，队列的特点是先进先出，当进队的时候先进到第一个栈中，出队的话，因为先进先出的特点，出队的时候考虑将第一个栈中的所有元素放到第二个栈中，输出栈顶，前提是第二个栈中的元素都输出完
```java
class CQueue {
    Stack<Integer> stk1,stk2;
    public CQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }
    
    public void appendTail(int value) {
       
        stk1.push(value);
    }
    
    public int deleteHead() {
        if(!stk2.isEmpty()){
            return stk2.pop();
        }
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
        if(!stk2.isEmpty()){
            return stk2.pop();
        }else{
            return -1;
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
 
 

```
## 5. 包含min函数的栈
> 解题思路：用一个栈来实现正常栈的操作，拿一个栈来进行记录最小数的记录。
```java
class MinStack {
    Stack<Integer> stk,stkMin;
    public MinStack() {
        stk = new Stack<>();
        stkMin = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(stkMin.isEmpty()||stkMin.peek() >= val){
            stkMin.push(val);
        }
    }
    
    public void pop() {
        int val = stk.pop();
        if(stkMin.peek() == val){
            stkMin.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return stkMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```
## 6. 替换空格
```java
class Solution {
    
    public String replaceSpaces(StringBuffer str) {
        String s = "";
        for(char c: str.toString().toCharArray()){
            if(c==' '){
                s += "%20";
            }else{
                s += c;
            }
        }
        return s;
    }
}
```
## 7. 从尾到头打印链表
>保存数组后，反转数组。或者反转链表后，输出到数组中
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] printListReversingly(ListNode head) {
        //逆置数组
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
            
        }
        int[] ans = new int[len];
        len = 0;
        while(head!=null){
            ans[len++] = head.val;
            head = head.next;
            
        }
        for(int i = 0; i < len/2; i++){
            int tmp = ans[i];
            ans[i] = ans[len-1-i];
            ans[len-1-i] = tmp;
        }
        return ans;
        
    }
}
```
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] printListReversingly(ListNode head) {
        ListNode pre =null,cur = head;
        int len = 0;
        while(cur!=null){
            len++;
            ListNode ne = cur.next;
            cur.next = pre;
            pre = cur;
            cur = ne;
        }
        int[] ans = new int[len];
        len = 0;
        while(pre!=null){
            ans[len++] = pre.val;
            pre = pre.next;
            
        }
        return ans;
        
    }
}
```