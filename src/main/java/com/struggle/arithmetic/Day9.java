package com.struggle.arithmetic;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 爬楼梯
 * 存在重复元素 II
 * 同构字符串
 * @author zhaobenquan
 */
public class Day9 {
    public static void main(String[] args) {
        //System.out.println(one(7));
//        int[] nums = {1,2,3,1,4,5,6,7,8,0,1,3,1,3};
//        System.out.println(two(nums,2));
          System.out.println(three("badc","baba"));
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     *
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    @SuppressWarnings("all")
    private static int one(int n){
        return circle(5);
    }

    /**
     * 递归
     * @param n
     * @return
     */
    private static int sub(int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return sub(n - 1);
        }else{
            return sub(n - 1) + sub(n - 2);
        }
    }

    /**
     * 循环
     * @param n
     * @return
     */
    private static int circle(int n){
        if(n == 1){return 1;}
        if(n == 2){return 2;}
        int a = 1, b = 2, temp;
        for(int i = 3; i <= n; i++){
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     *  
     * 示例 1:
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     *
     * 示例 2:
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     *
     * 示例 3:
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     *
     * 1,2,3,1,4,5,6,7,8,0,1,3,1,3
     */
    @SuppressWarnings("all")
    private static boolean two(int[] nums, int k){
        //窗口元素及其下标map
        Map<Integer,Integer> indexMap = new HashMap<>(k+1);
        for(int start = 0; start < nums.length - 1; start += (k + 1)){
            int i = start;
            Set<Integer> ele = new HashSet<>();
            while (i <= start + k && i < nums.length){
                if(indexMap.containsKey(nums[i]) && (i - indexMap.get(nums[i]) <= k)){
                    return true;
                }
                indexMap.put(nums[i],i);
                ele.add(nums[i]);
                i ++;
            }
            //判断当前窗口大小为i - start
            if(ele.size() < k + 1 && ele.size() < i - start){
                return true;
            }
        }
        return false;
    }

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *  
     * 示例 1:
     * 输入：s = "egg", t = "add"
     * 输出：true
     *
     * 示例 2：
     * 输入：s = "foo", t = "bar"
     * 输出：false
     *
     * 示例 3：
     * 输入：s = "paper", t = "title"
     * 输出：true
     *
     * 提示：
     * 可以假设 s 和 t 长度相同。
     * @return
     */
    private static boolean three(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int size = s.length();
        Map<Character ,Integer> hashValue = new HashMap<>(size);
        Set<Character> chatSet = new HashSet<>(size);
        for(int i = 0; i < size; i ++){
            chatSet.add(t.charAt(i));
            if(!hashValue.containsKey(s.charAt(i))){
                hashValue.put(s.charAt(i),t.charAt(i) - s.charAt(i));
            }else if(t.charAt(i) - s.charAt(i) != hashValue.get(s.charAt(i))){
                return false;
            }
        }
        return chatSet.size() == hashValue.size();
    }
}
