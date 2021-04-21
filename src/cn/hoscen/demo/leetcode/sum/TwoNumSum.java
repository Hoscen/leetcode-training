package cn.hoscen.demo.leetcode.sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description:
 * Created by Hoscen on 2021/4/21 12:46 with IntelliJ IDEA.
 */
public class TwoNumSum {

    public static void main(String[] args) {
        TwoNumSum twoNum = new TwoNumSum();
        int[] nums = {12, 3, 7, 4, 9, 11, 13};
        int target = 20;

        int[] ints = twoNum.twoSum(nums, target);
        System.out.println("twoNum.twoSum");
        System.out.println(Arrays.toString(ints));

        // 第二版
        int[] ints2 = twoNum.twoSum2(nums, target);
        System.out.println("twoNum.twoSum2");
        System.out.println(Arrays.toString(ints2));

    }

    /**
     * 第一版 2层for暴力解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) { // len - 1 是因为第一个数最多是倒数第2个
            for (int j = i + 1; j < len; j++) { // 第2个值永远在第一个值后面，所以j=i+1
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 第二版 利用哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        // 思路：依次将每个数以及它的下标记录下来，然后拿后续的每个数与target的差值去map里面匹配，如果存在，则为找到了目标结果。
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len - 1);
        map.put(nums[0], 0); // 记录值和对应下标
        for (int i = 1; i < len; i++) {
            int oldval = target - nums[i];
            if (map.containsKey(oldval)) { // 在之前记录的值中匹配，如有，则之前记录的这个下标和当前下标为目标结果
                return new int[]{map.get(oldval), i};
            }
            map.put(nums[i], i); // 没有匹配到就记下当前数以及下标，以供后续的数去匹配
        }
        return null;
    }
}
