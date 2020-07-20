package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Leet_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int size = nums1.length > nums2.length ? nums1.length : nums2.length;
        Map<Integer, Integer> map = new HashMap<>(size);
        // 1、将num1的值存放到map中
        for (int i = 0; i < nums1.length; i++) {
            int value = nums1[i];
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        // 2、循环num2，如果map中有值，则对应减1
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            int value = map.getOrDefault(key, 0);
            if (value == 0) {
                continue;
            }
            list.add(key);
            map.put(key, value - 1);
        }

        int[] num = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i] = list.get(i);
        }

        return num;
    }

    public static void main(String[] args) {
        Leet_350 leet350 = new Leet_350();
        int[] num1 = new int[]{1, 2, 3, 4};
        int[] num2 = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(leet350.intersect(num1, num2)));
    }
}
