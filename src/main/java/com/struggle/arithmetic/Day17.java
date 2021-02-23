package com.struggle.arithmetic;

/**
 * 19. 删除链表的倒数第 N 个结点
 * @author zhaobenquan
 */
public class Day17 {
    public static void main(String[] args) {
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 进阶：你能尝试使用一趟扫描实现吗？
     *  
     * 示例 1：
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 示例 2：
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 示例 3：
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     * 提示：
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @SuppressWarnings("all")
    public static ListNode one(ListNode head, int n) {
        if(n == 1){
            //直接遍历
            ListNode result = new ListNode();
            ListNode temp = result;
            while (head.next != null){
                temp.next = new ListNode(head.val);
                head = head.next;
                temp = temp.next;
            }
            return result.next;
        }
        //双指针
        ListNode start = head;
        ListNode end = new ListNode(head.val);
        for(int i = 0; i < n - 1; i ++){
            end.next = start.next;
            end = end.next;
            start = start.next;
        }
        start = head;
        ListNode breakBefore = new ListNode();
        ListNode temp = breakBefore;
        while (end.next != null){
            temp.next = new ListNode(start.val);
            start = start.next;
            end = end.next;
            temp = temp.next;
        }
        temp.next = start.next;
        return breakBefore.next;
    }
}
