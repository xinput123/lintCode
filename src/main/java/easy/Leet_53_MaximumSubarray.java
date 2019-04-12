package easy;

/**
 * Maximum Subarray
 * 最大连续数组
 * <p>
 * 给定整数数组nums，找到具有最大总和并返回其总和的连续子数组
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-11 23:56
 */
public class Leet_53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(max, sum[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 10, 9, -4, -3, 8, -10};
        System.out.println(new Leet_53_MaximumSubarray().maxSubArray(a));
    }
}
