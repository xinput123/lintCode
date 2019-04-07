package easy;

import java.util.HashMap;

/**
 * 给定一个整数数组，返回两个数字的索引，使他们相加得到特定结果
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-07 20:16
 * <p>
 * Runtime: 2 ms
 * Memory Usage: 38.4 MB
 */
public class Leet_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                firstIndex = i;
                secondIndex = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }

        if (firstIndex > secondIndex) {
            index[0] = secondIndex;
            index[1] = firstIndex;
        } else {
            index[0] = firstIndex;
            index[1] = secondIndex;
        }
        return index;
    }

    public static void main(String[] args) {

    }
}
