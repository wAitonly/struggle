package com.struggle.arithmetic;

/**
 * 合并K个升序链表
 * @author zhaobenquan
 */
public class Day14 {
    public static void main(String[] args) {
        //System.out.println(one(7));
    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     *
     * 提示：
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */
    static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode one(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode result = lists[0];
        for(int i = 1; i < lists.length; i++){
            result = merge(result,lists[i]);
        }
        return result;
    }

    private static ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode result = new ListNode(0,head);
        while (null != l1 || null != l2){
            if(l1 == null){
                head.next = l2;
                break;
            }else if(l2 == null){
                head.next = l1;
                break;
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
