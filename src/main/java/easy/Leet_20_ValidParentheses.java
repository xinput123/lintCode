package easy;

/**
 * 有效的括号
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-07 20:59
 * <p>
 * Runtime: 92 ms
 * Memory Usage: 39.1 MB
 */
public class Leet_20_ValidParentheses {
    public boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            if (s.isEmpty()) {
                break;
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Leet_20_ValidParentheses().isValid("(([]){})"));
    }
}
