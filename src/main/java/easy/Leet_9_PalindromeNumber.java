package easy;

/**
 * 确定整数是否是回文。当它从前读和从后读是完全相同的
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-03 00:51
 */
public class Leet_9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        // 将整数转化成数组
        String string = Integer.toString(x);
        char[] chars = string.toCharArray();
        // 利用数组的双向遍历
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leet_9_PalindromeNumber().isPalindrome(12321));
        System.out.println(new Leet_9_PalindromeNumber().isPalindrome(-2123));
    }
}
