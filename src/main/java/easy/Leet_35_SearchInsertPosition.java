package easy;

/**
 * Search Insert Position
 * 搜索插入的位置
 * <p>
 * 要求：
 * 给定排序数组和目标值，如果找到目标，则返回索引。如果没有，请返回索引按顺序插入的索引。
 * <p>
 * Example：
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-10 11:27
 */
public class Leet_35_SearchInsertPosition {
    /**
     * Runtime: 0 ms
     * Memory Usage: 39.5 MB
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 6};
        System.out.println(new Leet_35_SearchInsertPosition().searchInsert(a, 0));
    }
}
