package easy;

/**
 * Plus One
 * 加一
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-19 00:28
 */
public class Leet_66_PlusOne {
    /**
     * Result
     * Runtime: 0 ms
     * Memory Usage: 37.3 MB
     */
    public int[] plusOne(int[] digits) {
        // 进位
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + carry;
            carry = value / 10;
            digits[i] = value % 10;

            // 等于0，就表示不用进位了，循环也就可以停止了
            if (carry == 0) {
                return digits;
            }
        }

        int res[] = null;
        // 如果最高位计算后，依然有进位，就表示需要向前继续一位即可，后面都是0
        if (carry >= 1) {
            //int 数组默认值为0
            res = new int[digits.length + 1];
            //最高位置1 就可以，其他位，全是0
            res[0] = carry;
        }
        return res;
    }
}
