package com.struggle.arithmetic;


import java.util.*;
import java.util.stream.IntStream;

/**
 * 无重复字符的最长子串
 * 两数相加
 * @author zhaobenquan
 */
public class Day2 {
    public static void main(String[] args) {
        //one();
        two();
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 示例 4:
     * 输入: s = ""
     * 输出: 0
     *  
     * 提示：
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    private static void one(){
        String s = "abcabcbb";
        //双指针
        String resultStr;
        int result = 0;
        int size = s.length();
        int start = 0;
        int end = 0;
        while (end < size){
            resultStr = s.substring(start,end);
            if(resultStr.length() >= result){
                result = resultStr.length();
            }
            char cEnd = s.charAt(end);
            if(resultStr.indexOf(cEnd) != -1){
                while (start < end){
                    char cStart = s.charAt(start);
                    if(cStart == cEnd){
                        start++;
                        break;
                    }
                    start++;
                }
            }
            end++;
        }
        resultStr = s.substring(start,end);
        if(resultStr.length() >= result){
            result = resultStr.length();
        }
        System.out.println("结果为："+result);
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例 1：
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * 示例 2：
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     *
     * 示例 3：
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *  
     * 提示：
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     */
    private static void two(){
        List<Integer> l1 = Arrays.asList(9,9,9,9,9,9,9);
        List<Integer> l2 = Arrays.asList(9,9,9,9);
        //对应位相加
        int size1 = l1.size();
        int size2 = l2.size();
        int size = size1 > size2? size1 : size2;
        List<Integer> result = new ArrayList<>();
        IntStream.range(0,size+1).forEach(i -> result.add(i,0));
        IntStream.range(0,size).forEach(i -> {
            int a = 0;
            int b = 0;
            int total;
            if(i < size1){
                a = l1.get(i);
            }
            if(i < size2){
                b = l2.get(i);
            }
            total = a + b;
            if(total+result.get(i) >= 10){
                if(total +result.get(i) >= 20){
                    result.set(i,total+result.get(i)-20);
                    result.set(i+1,2);
                }else {
                    result.set(i,total+result.get(i)-10);
                    result.set(i+1,1);
                }
            }else {
                result.set(i,total+result.get(i));
            }
        });
        int index = result.lastIndexOf(0);
        if(index == result.size() - 1){
            result.remove(index);
        }
        System.out.println(result);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @SuppressWarnings("all")
    private static ListNode two(ListNode l1,ListNode l2){
        ListNode result = new ListNode();
        ListNode temp = result;
        do{
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int total = a + b;
            if(total+temp.val >= 10){
                if(total + temp.val >= 20){
                    temp.val = total + temp.val - 20;
                    temp.next = new ListNode(2);
                }else {
                    temp.val = total + temp.val - 10;
                    temp.next = new ListNode(1);
                }
            }else if((l1 == null || l1.next == null) && (l2 == null || l2.next == null)){
                temp.val = total + temp.val;
            }else {
                temp.val = total + temp.val;
                temp.next = new ListNode(0);
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            temp = temp.next;
        }while (null != l1 || null != l2);
        return result;
    }
}
