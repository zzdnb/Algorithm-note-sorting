---
title: 链表专题
date: 2021-12-14 17:48:06.808
updated: 2022-01-28 11:32:41.703
url: /archives/lian-biao-zhuan-ti
categories: 算法
tags: 链表
---

[TOC](这里写目录标题)
## 单链表

### 链表定义

```c++
struct ListNode {
    int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};
```

### 链表环的入口结点（AC34）

```C++
解析:
https://blog.csdn.net/qq_43688587/article/details/119641380
ListNode *entryNodeOfLoop(ListNode *head) {
        if(!head || !head->next){
            return head;
        }
        ListNode * fast = head, * last = head;
        while(fast && last){
            fast = fast->next;
            last = last->next;
            if(fast){
                fast = fast->next;
            }else{
                return NULL;
            }
            if(fast == last){
                fast = head;
                while(fast != last){
                    fast = fast->next;
                    last = last->next;
                }
                return fast;
            }
            
        }
    }
}
```

### 单链表的快速排序（AC1451）

```c++
   ListNode * get_tail(ListNode *head){
        while(head->next){
            head = head->next;
        }
        return head;
    }
    ListNode* quickSortList(ListNode* head) {
          if(!head||!head->next){
            return head;
        }
        ListNode *left = new ListNode(-1), *mid = new ListNode(-1), * right = new ListNode(-1);
        ListNode * ltail = left, *mtail = mid, *rtail = right;
        auto val = head->val;
        for(auto p = head; p; p = p->next){
            if(p->val < val){
                ltail = ltail->next = p;
            }else if( p->val == val){
                mtail = mtail->next = p;
            }else{
                rtail = rtail->next = p;
            }
        }
        ltail->next = mtail->next = rtail->next = NULL;
        
        left->next = quickSortList(left->next);
        right->next = quickSortList(right->next);
        
        get_tail(left)->next = mid->next;
        get_tail(left)->next = right->next;
        return left->next;
    }
```

### 反转链表(AC35)

```c++
    ListNode* reverseList(ListNode* head) {
        ListNode * pre = NULL,*cur = head;
        while(cur){
            ListNode* ne = cur->next;
            cur->next = pre;
            pre = cur;
            cur = ne;
        }
        return pre;
    }
```

```c++
ListNode* reverseList(ListNode* head) {
       if(!head || !head->next){
           return head;
       }
       
        auto res = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return res;
    }
```

### 删除排序链表中的重复元素（LC83）

```c++
ListNode* reverseList(ListNode* head) {
       if(!head || !head->next){
           return head;
       }
       
        auto res = reverseList(head->next);
        head->next->next = head;
        head->next = NULL;
        return res;
    }
```

### 删除排序链表中的重复元素 II（LC82）

```c++
   public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null){
        	ListNode q = p.next;
           	while(q.next!=null&&q.next.val==p.next.val){
            	q=q.next;
           }
           if(q == p.next){
               p = q;
           }else{
               p.next = q.next;
           }

        }
        return dummy.next;
    }
```



### 删除链表的倒数第 N 个结点(LC19)

```c++
ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode * pre = new ListNode(0,head);
        ListNode * cur = pre;
        int cnt = 0;
        while(head){ 
            cnt++;
            head = head->next; 
        }
        for(int i = 0; i < cnt-n; i++){
            cur = cur->next;  
        }
        cur->next = cur->next->next;

        return pre->next;
}
```

### LeetCode2.两数相加（高精度加法）
```
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// \U0001f44d 7013 \U0001f44e 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int tmp = 0;
        while(l1!=null||l2!=null||tmp > 0){
            cur.next = new ListNode();
            cur = cur.next;
            if(l1!=null){
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                tmp += l2.val;
                l2 = l2.next;
            }
            
            cur.val = tmp%10;
            tmp /= 10;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

```

### LeetCode445.两数相加Ⅱ（高精度加法+栈）

### LeetCode19.删除链表的倒数第N个节点

### LeetCode21.合并两个有序链表
### LeetCode23.合并K个升序链表（多路归并）
### LeetCode24.两两交换链表中的节点
### LeetCode25.K个一组翻转链表
```java
import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */ 
    int[] arr = new int[2010];
    void reverse(int l,int r){
        for(; l < r; l++,r--){
           int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head == null){
            return head;
        }
        ListNode cur = head;
        int cnt = 0;
       
        while(cur!=null){
           
            arr[++cnt] = cur.val; 
            cur = cur.next;
        }
        for(int i = 1 + k-1; i <= cnt; i = i + k){
            reverse(i-k+1,i);
        }
        cur = head;
        for(int i = 1; i <= cnt; i++){
            cur.val = arr[i];
            cur = cur.next;
        }
        return head;
        
    }
}
```
### LeetCode61.旋转链表（快慢指针）
### LeetCode83.删除排序链表中的重复元素
### LeetCode82.删除排序链表中的重复元素Ⅱ
### LeetCode86.分隔链表
### LeetCode206.翻转链表
### LeetCode92.反转链表Ⅱ
### LeetCode141.环形链表
### LeetCode142.环形链表Ⅱ
### LeetCode143.重排链表
### LeetCode160.相交链表
### LeetCode203.移除链表元素
### LeetCode234.回文链表
双指针加链表反转
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        // write code here
        ListNode fast = head, last = head;
        while(fast != null && last != null){
            fast = fast.next;
            last = last.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        ListNode cur = last, pre = null;
        while(cur!=null){
            ListNode ne = cur.next;
            cur.next = pre;
            pre = cur;
            cur = ne;
        }
        while(pre!=null){
            if(pre.val!=head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
        
    }
    
}
```
### LeetCode237.删除链表中的节点
### LeetCode328.奇偶链表
### LeetCode707.设计链表（设计单链表，双链表模板题）
### LeetCode876.链表的中间节点