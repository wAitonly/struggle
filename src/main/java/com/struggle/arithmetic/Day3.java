package com.struggle.arithmetic;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 最长回文子串
 * 寻找两个正序数组的中位数
 * @author zhaobenquan
 */
public class Day3 {
    public static void main(String[] args) {
        //one();
        two();
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     *
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     *  
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     */
    @SuppressWarnings("all")
    private static void one(){
        String s = "aacabdkacaa";
        //暴力求解
        String result;
        int size = s.length();
        if(size == 1){
            result = s;
        }else {
            Map<Double,Double> resultIndex = new HashMap<>(1);
            IntStream.range(0,size - 1).forEach(i -> {
                int step = 1;
                while (i - step >= 0 && (i + step <= size - 1)){
                    int start = i - step;
                    int end = i + step;
                    if(s.charAt(start) != s.charAt(end)){
                        break;
                    }
                    if(resultIndex.size() > 0){
                        Double key = resultIndex.keySet().iterator().next();
                        if(step * 2 > resultIndex.get(key) - key){
                            resultIndex.clear();
                            resultIndex.put((double) start, (double) end);
                        }
                    }else {
                        resultIndex.put((double) start, (double) end);
                    }
                    step ++;
                }
                //------------
                double step2 = 1.5;
                double mid2 = i + 0.5;
                if(s.charAt(i) == s.charAt(i + 1)){
                    if(resultIndex.size() > 0){
                        Double key = resultIndex.keySet().iterator().next();
                        if(2 > resultIndex.get(key) - key){
                            resultIndex.clear();
                            resultIndex.put((double)i,(double)i + 1);
                        }
                    }else {
                        resultIndex.put((double)i,(double)i + 1);
                    }
                    while (mid2 - step2 >= 0 && (mid2 + step2 <= size - 1)){
                        double start = mid2 - step2;
                        double end = mid2 + step2;
                        if(s.charAt((int) start) != s.charAt((int) end)){
                            break;
                        }
                        if(resultIndex.size() > 0){
                            Double key = resultIndex.keySet().iterator().next();
                            if(step2 * 2 > resultIndex.get(key) - key){
                                resultIndex.clear();
                                resultIndex.put(start,end);
                            }
                        }else {
                            resultIndex.put(start,end);
                        }
                        step2 ++;
                    }
                }
            });
            if(resultIndex.size() > 0){
                Double resultStart = resultIndex.keySet().iterator().next();
                result = s.substring(resultStart.intValue(),resultIndex.get(resultStart).intValue() + 1);
            }else {
                result = String.valueOf(s.charAt(0));
            }
        }
        System.out.println(result);
    }

    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
     * 实现 LRUCache 类：
     *
     * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     *  
     *
     * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
     *
     * 示例：
     *
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *  
     * 提示：
     * 1 <= capacity <= 3000
     * 0 <= key <= 3000
     * 0 <= value <= 104
     * 最多调用 3 * 104 次 get 和 put
     */

    @SuppressWarnings("all")
    static class LRUCache extends LinkedHashMap<Integer, Integer>{
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    private static void two(){
        LRUCache obj = new LRUCache(2);
        int param = obj.get(1);
        obj.put(1,1);
        System.out.println(param);
    }


}
