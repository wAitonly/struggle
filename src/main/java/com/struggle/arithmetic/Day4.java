package com.struggle.arithmetic;


/**
 * 反转链表
 * @author zhaobenquan
 */
public class Day4 {
    public static void main(String[] args) {
        //one();
    }

    /**
     * 反转一个单链表。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @SuppressWarnings("all")
    private static ListNode one(ListNode head){
        return reversal(head,null);
    }

    @SuppressWarnings("all")
    private static ListNode reversal(ListNode node,ListNode nodeNext){
        if(null == node){
            return null;
        }
        ListNode children = node.next;
        node.next = nodeNext;
        if(null != children){
            node = reversal(children,node);
        }
        return node;
    }
}
