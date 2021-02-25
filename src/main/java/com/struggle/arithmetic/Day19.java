package com.struggle.arithmetic;

/**
 * 344. 反转字符串
 * @author zhaobenquan
 */
public class Day19 {
    public static void main(String[] args) {
        char[] param = {'h','e','l','l','o'};
        one(param);
        System.out.println(param);
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * 示例 1：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     */
    @SuppressWarnings("all")
    public static void one(char[] s) {
        int size = s.length;
        if(size > 1){
            int head = 0;
            int tail = size - 1;
            char temp;
            while (head <= tail){
                temp = s[head];
                s[head] = s[tail];
                s[tail] = temp;
                head ++;
                tail --;
            }
        }
    }
}
