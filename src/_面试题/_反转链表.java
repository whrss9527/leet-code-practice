package _面试题;

import java.util.HashMap;

/**
 * 反转链表
 */

public class _反转链表 {
    public ListNode reverse(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        // 1 -> 2 -> 3 -> 4
        node.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode pre = null;
        while (node != null){
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return node;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
    TreeNode(){

    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
    ListNode(){

    }
}

