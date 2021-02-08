package com.struggle.arithmetic;


/**
 * 整数反转
 * @author zhaobenquan
 */
public class Day5 {
    public static void main(String[] args) {
        System.out.println(one(-2147483648));
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2的31次方,  2的31次方 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
     * 示例 1：
     * 输入：x = 123
     * 输出：321
     *
     * 示例 2：
     * 输入：x = -123
     * 输出：-321
     *
     * 示例 3：
     * 输入：x = 120
     * 输出：21
     *
     * 示例 4：
     * 输入：x = 0
     * 输出：0
     *  
     * 提示：
     * -2的31次方 <= x <= 2的31次方 - 1
     */
    @SuppressWarnings("all")
    private static int one(int x){
        if(x < 10 && x > -10){
            return x;
        }
        //特殊处理-2147483648,32位整数范围为[-2147483648,  2147483647]
        if(x == -2147483648){
            return 0;
        }
        StringBuilder resultStr = new StringBuilder();
        int flag = 1;
        if(x < 0){
            flag = -1;
            x = x * -1;
        }
        while (x >= 10){
            resultStr.append(String.valueOf(x % 10));
            x = x / 10;
        }
        resultStr.append(String.valueOf(x));
        try {
            return Integer.valueOf(resultStr.toString()) * flag;
        }catch (NumberFormatException e){
            return 0;
        }
    }
}
