package com.struggle.arithmetic;

/**
 * 33. 搜索旋转排序数组
 * @author zhaobenquan
 */
public class Day18 {
    public static void main(String[] args) {
        int[] param = {4,5,6,7,0,1,2};
        System.out.println(one(param,0));
    }

    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
     *  
     * 示例 1：
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * 示例 2：
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     *
     * 示例 3：
     * 输入：nums = [1], target = 0
     * 输出：-1
     *  
     * 输入：nums = [4,5,6,7,8,1,2,3], target = 8
     * 输入：nums = [5,6,7,0,1,2,4], target = 6
     *
     * 提示：
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * nums 肯定会在某个点上旋转
     * -10^4 <= target <= 10^4
     */
    @SuppressWarnings("all")
    public static int one(int[] nums, int target) {
        //记下首尾元素
        int size = nums.length;
        //二分查找
        int head = 0;
        int tail = size - 1;
        int index;
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }
        while (tail != head && head < size && tail >= 0){
            index = (head + tail) / 2;
            //首尾判断
            if(nums[head] == target){
                return head;
            }
            if(nums[tail] == target){
                return tail;
            }
            //中间查找4,5,6,7,8,1,2,3  8
            //中间查找7,8,1,2,3,4,5,6,  1
            if(nums[index] == target){
                return index;
            }
            if(nums[index] >= nums[head] || nums[index] > nums[tail]){
                //左边有序，右边可能形成旋转
                if(nums[index] > target && nums[head] < target){
                    //左边继续查找
                    tail = index - 1;
                }else {
                    head = index + 1;
                }
            }else if(nums[index] <= nums[tail] || nums[index] < nums[head]){
                //右边有序，左边可能形成旋转
                if(nums[index] < target && nums[tail] > target){
                    //右边继续查找
                    head = index + 1;
                }else {
                    tail = index - 1;
                }
            }else {
                //左右都有序
                if(nums[index] < target){
                    head = index + 1;
                }else {
                    tail = index - 1;
                }
            }
        }
        return -1;
    }
}
