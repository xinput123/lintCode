package hard;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        // 得到数组长度为 n ，则缺失的第一个正数就在 [1,n + 1] 之间。
        int n = nums.length;
        // 将数组中的 0 和负数赋值为 n + 1 （此时缺失正数一定小于 n + 1）。
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        // 将以出现过的正数为索引位置的数置为负数。
        for (int i = 0; i < n; i++) {
            // 遍历将每个位置的值取绝对值表示出现过的正数。
            int num = Math.abs(nums[i]);
            if (num <= n) {
                // 值在 [1,n] 范围内则将以当前值为索引位置值置为负数。
                nums[num - 1] = -Math.abs(nums[num - 1]);
                System.out.println(Arrays.toString(nums));
            }
        }
        System.out.println("=====");
        System.out.println(Arrays.toString(nums));
        // 遍历数组索引，第一个值为正数的位置表示当前索引 +1 的正数缺失。
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 遍历完成，则说明数组长度 +1 的值缺失。
        return n + 1;
    }

    public static void main(String[] args) {
        Solution41 s = new Solution41();
        int[] nums = {-3, 2, 1, 4, 4, 5};
        System.out.println(s.firstMissingPositive(nums));
    }
}
