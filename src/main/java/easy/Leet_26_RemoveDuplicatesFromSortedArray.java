package easy;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array
 * 从排序数组中删除重复项
 * <p>
 * 要求：
 * 1、给定排序的数组nums，就地删除重复项，使每个元素只出现一次并返回新的长度
 * 2、不要为另一个数组分配额外的空间，必须通过使用O（1）额外内存修改输入数组来实现此目的。
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-09 09:42
 */
public class Leet_26_RemoveDuplicatesFromSortedArray {
    /**
     * Runtime: 1 ms
     * Memory Usage: 40.8 MB
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 只要数组不为空，必然有值
        int length = 1;
        // 从第二个数组开始比较，对应 length=1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] != nums[length]) {
                    nums[length] = nums[i];
                }
                length++;
            }
        }
        System.out.println(Arrays.toString(nums));

        return length;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 4, 4, 5};
        System.out.println(new Leet_26_RemoveDuplicatesFromSortedArray().removeDuplicates(a));
    }
}
