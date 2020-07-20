package easy;

/**
 * @Author: xinput
 * @Date: 2020-07-17 07:15
 */
public class Leet_35 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (nums[0] > target) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i + 1 < length && nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Leet_35 leet = new Leet_35();
        int nums[] = new int[]{1, 3, 5, 6};
        int target = 2;
        System.out.println(leet.searchInsert(nums, target));
    }
}
