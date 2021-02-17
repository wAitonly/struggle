package com.struggle.arithmetic;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 两数之和
 * 寻找两个正序数组的中位数
 * @author zhaobenquan
 */
public class Day1 {
    public static void main(String[] args) {
        one();
        two();
    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * 示例 2：
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 示例 3：
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * 提示：
     * 2 <= nums.length <= 103
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     */
    private static void one(){
        List<Integer> nums = Arrays.asList(3,2,4);
        Integer target = 6;
        //遍历nums,计算各位置与target的差值，并生成nums中值与下标的map
        int size = nums.size();
        LinkedHashMap<Integer,String> indexMap = new LinkedHashMap<>(size);
        List<Integer> deviation = new ArrayList<>(size);
        IntStream.range(0,size).forEach(i->{
            Integer num = nums.get(i);
            if(indexMap.containsKey(num)){
                indexMap.replace(num,indexMap.get(num) + "#" + i);
            }else {
                indexMap.put(num,String.valueOf(i));
            }
            deviation.add(target - num);
        });
        //nums和deviation的交集即为两个和为target的两个数
        //遍历deviation,并从indexMap中拿到下标
        List<Integer> index = new ArrayList<>(2);
        IntStream.range(0,size).forEach(i->{
            //对应差值
            Integer deviationValue = deviation.get(i);
            if(null != indexMap.get(deviationValue)){
                String[] indexAry = indexMap.get(deviationValue).split("#");
                //同一元素不能使用两次
                if(indexAry.length == 1 && i != Integer.valueOf(indexAry[0])){
                    index.add(Integer.valueOf(indexAry[0]));
                }else if(indexAry.length == 2){
                    //这两个重复数必为需要找的两个数
                    index.add(Integer.valueOf(indexAry[0]));
                    index.add(Integer.valueOf(indexAry[1]));
                    //删除indexMap中该键值对，防止重复读取
                    indexMap.remove(deviationValue);
                }
            }
        });
        System.out.println("结果："+index);
    }

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *
     * 示例 1：
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     * 示例 2：
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * 示例 3：
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     *
     * 示例 4：
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     *
     * 示例 5：
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *
     * 提示：
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */
    @SuppressWarnings("all")
    private static void two(){
        List<Integer> num1 = Arrays.asList(1);
        List<Integer> num2 = Arrays.asList(1);
        //先合并排序
        List<Integer> sortList;
        if(CollectionUtils.isEmpty(num1) && CollectionUtils.isEmpty(num2)){
            sortList = new ArrayList<Integer>(){{add(0);}};
        }else if(CollectionUtils.isEmpty(num1)){
            sortList = new ArrayList<>(num2);
        }else if(CollectionUtils.isEmpty(num2)){
            sortList = new ArrayList<>(num1);
        }else {
            sortList = new ArrayList<>(num1);
            num2.forEach(a -> {
                int size1 = sortList.size();
                //利用二分法将num2中元素按序插入到num1中
                int start = 0;
                int end = size1 - 1;
                int mid = (start + end) / 2;
                if(sortList.get(end) <= a){
                    //大于num1的最大值直接放在尾部
                    sortList.add(sortList.size(),a);
                }else if(sortList.get(start) > a){
                    //小于num1的最小值直接放在首部
                    sortList.add(0,a);
                }else {
                    while (!sortList.get(mid).equals(a) || sortList.get(mid) > a || sortList.get(mid + 1) <= a){
                        if(sortList.get(mid) > a){
                            //左半部分继续二分
                            end = mid;
                        }else if(sortList.get(mid + 1) < a){
                            //右半部分继续二分
                            start = mid;
                        }else if(sortList.get(mid + 1).equals(a)){
                            //直接break
                            mid++;
                            break;
                        }else {
                            //正好在中间
                            break;
                        }
                        mid = (start + end) / 2;
                    }
                    sortList.add(mid + 1,a);
                }
            });
        }
        System.out.println(sortList);
        //求排序后的中位数
        double result;
        int finalSize = sortList.size();
        if(finalSize % 2 == 0){
            result = (sortList.get(finalSize / 2) + sortList.get((finalSize / 2) - 1) + 0.0) / 2;
        }else {
            result = sortList.get((finalSize - 1) / 2);
        }
        System.out.println("中位数为："+result);
    }
}
