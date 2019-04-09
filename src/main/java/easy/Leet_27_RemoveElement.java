package easy;

/**
 * 移除元素
 * <p>
 * 要求：
 * 1、不要为另一个数组分配额外的空间
 * 2、必须通过使用O（1）额外内存修改输入数组来实现此目的。
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-09 10:10
 */
public class Leet_27_RemoveElement {
    /**
     * Runtime: 0 ms
     * Memory Usage: 37.4 MB
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = 0;
        // 从第二个数组开始比较，对应 length=1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (nums[i] != nums[length]) {
                    nums[length] = nums[i];
                }
                length++;
            }
        }

        return length;
    }
}
