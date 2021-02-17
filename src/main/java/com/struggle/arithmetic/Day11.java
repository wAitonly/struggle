package com.struggle.arithmetic;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 有效的括号
 * @author zhaobenquan
 */
public class Day11 {
    public static void main(String[] args) {
        System.out.println(one("([)]"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 1.左括号必须用相同类型的右括号闭合。
     * 2.左括号必须以正确的顺序闭合。
     *  
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     *
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     *
     * 示例 4：
     * 输入：s = "([)]"
     * 输出：false
     *
     * 示例 5：
     * 输入：s = "{[]}"
     * 输出：true
     *  
     * 提示：
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     */
    @SuppressWarnings("all")
    private static boolean one(String s){
        int size = s.length();
        if(size == 0 || size % 2 != 0){
            //奇数长度的字符串直接false
            return false;
        }
        //遍历剔除所有的相邻闭合
        List<Character> charList = new ArrayList<>(size);
        IntStream.range(0,size).forEach(i -> {
            if(charList.size() > 0 && isClose(charList.get(charList.size() - 1),s.charAt(i))){
                charList.remove(charList.size() - 1);
            }else {
                charList.add(s.charAt(i));
            }
        });
        return charList.size() == 0;
    }

    private static boolean isClose(char a,char b){
        if("(".charAt(0) == a){
            return ")".charAt(0) == b;
        }else if("[".charAt(0) == a){
            return "]".charAt(0) == b;
        }else if("{".charAt(0) == a){
            return "}".charAt(0) == b;
        }
        return false;
    }
}
