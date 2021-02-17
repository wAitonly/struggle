package com.struggle.arithmetic;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 接雨水
 * @author zhaobenquan
 */
public class Day12 {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5,5,3,6,7,3,9,5,1,8};
        System.out.println(one(height));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例 1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *
     * 示例 2：
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *  
     * 提示：
     * n == height.length
     * 0 <= n <= 3 * 104
     * 0 <= height[i] <= 105
     */
    @SuppressWarnings("all")
    private static int one(int[] height){
        int result = 0;
        int start = 0;
        while (start < height.length){
            int temp = 0;
            int end = start + 1;
            while (end < height.length){
                if(height[end] < height[start]){
                    temp += height[start] - height[end];
                    end ++;
                }else {
                    result += temp;
                    break;
                }
            }
            if(end == height.length && height[end - 1] < height[start]){
                height[start] = height[start] - 1;
            }else {
                start = end;
            }
        }
        return result;
    }
}
