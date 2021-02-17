package com.struggle.arithmetic;

/**
 * 合并两个有序链表
 * @author zhaobenquan
 */
public class Day10 {
    public static void main(String[] args) {
        //System.out.println(one(7));
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     *
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     */
    static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @SuppressWarnings("all")
    private static ListNode one(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode result = new ListNode(0,head);
        while (null != l1 || null != l2){
            if(l1 == null){
                head.next = new ListNode(l2.val);
                l2 = l2.next;
                head = head.next;
                continue;
            }else if(l2 == null){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
                head = head.next;
                continue;
            }else if(l1.val <= l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        return result.next.next;
    }
}
