package easy;

/**
 * 给定32位有符号整数，输出整数的反向数字。
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-03 00:16
 */
public class Leet_7_ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // 防止溢出
            if (rev != 0 && Integer.MAX_VALUE / rev < 10 && Integer.MAX_VALUE / rev > -10) {
                return 0;
            }
            // 1、给一个数字，比如 12345
            // 2、第一次结果：rev = 5 , x = 1234
            // 3、第二次结果：rev = 4+5*10 , x = 123
            // 4、第三次结果：rev = 3 + 54*10 , x = 12
            // 5、第四次结果：rev = 2 + 543*10 , x = 1
            // 6、第五次结果：rev = 1+5432*10 , x = 0
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        int i = 12345;
        int reverseInt = new Leet_7_ReverseInteger().reverse(i);
        System.out.println(i + " ---> " + reverseInt);

        i = -12345;
        reverseInt = new Leet_7_ReverseInteger().reverse(i);
        System.out.println(i + " ---> " + reverseInt);
    }
}
