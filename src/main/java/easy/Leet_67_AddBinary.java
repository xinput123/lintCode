package easy;

/**
 * 给定两个字符串，计算二进制之和
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-25 00:37
 */
public class Leet_67_AddBinary {
    /**
     * Runtime: 2 ms,
     * Memory Usage: 37 MB
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        // 根据进位
        int carry = 0;

        // 长度-1
        int al = a.length() - 1;
        int bl = b.length() - 1;

        while (al >= 0 || bl >= 0) {
            int sum = 0;

            if (al >= 0 && a.charAt(al) == '1') {
                sum++;
            }

            if (bl >= 0 && b.charAt(bl) == '1') {
                sum++;
            }

            sum += carry;

            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }

            sb.insert(0, (char) ((sum % 2) + '0'));

            al--;
            bl--;
        }

        if (carry == 1) {
            sb.insert(0, '1');
        }


        return sb.toString();
    }
}
