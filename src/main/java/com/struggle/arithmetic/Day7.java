package com.struggle.arithmetic;


/**
 * 回文数
 * 4的幂
 * @author zhaobenquan
 */
public class Day7 {
    public static void main(String[] args) {
        //System.out.println(one(121));
        System.out.println(two(-31));
    }

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     *
     * 示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     *
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     *
     * 示例 4：
     * 输入：x = -101
     * 输出：false
     *  
     * 提示：
     * -231 <= x <= 231 - 1
     *  
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     */
    @SuppressWarnings("all")
    private static boolean one(int x){
        if(x < 0){
            return false;
        }
        if(x >=0 && x < 10){
            return true;
        }
        //整数反转
        int num = x;
        int result = 0;
        while (x >= 10){
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        result = result * 10 + x;
        return result == num;
    }

    /**
     * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
     *  
     * 示例 1：
     * 输入：n = 16
     * 输出：true
     *
     * 示例 2：
     * 输入：n = 5
     * 输出：false
     *
     * 示例 3：
     * 输入：n = 1
     * 输出：true
     *
     * 提示：
     * -231 <= n <= 231 - 1
     *
     * 进阶：
     * 你能不使用循环或者递归来完成本题吗？
     * @param n
     * @return
     */
    private static boolean two(int n){
        if(n <= 0){
            return false;
        }
        if( n == 1){
            return true;
        }
        while (n >= 4){
            if(n % 4 != 0){
                break;
            }
            n = n / 4;
        }
        if(n == 1){
            return true;
        }
        return false;
    }
}
