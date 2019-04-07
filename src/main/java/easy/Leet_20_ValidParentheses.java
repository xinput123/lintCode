package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-07 20:59
 */
public class Leet_20_ValidParentheses {
    /**
     * 直接使用字符串替换
     * Runtime: 92 ms
     * Memory Usage: 39.1 MB
     *
     * @param s
     * @return
     */
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

    /**
     * 使用堆栈
     * Runtime: 2 ms
     * Memory Usage: 36.8 MB
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Map<String, String> map = new HashMap();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        Stack<String> stack = new Stack<>();
        // 方便计算，防止第一个字符是 )]}
        stack.push("-1");
        for (int i = 0; i < s.length(); i++) {
            String si = String.valueOf(s.charAt(i));
            if ("(".equals(si) || "[".equals(si) || "{".equals(si)) {
                stack.push(si);
            } else {
                if (!map.get(si).equals(stack.pop())) {
                    return false;
                }
            }
        }
        // 取出第一个字符是 )]}
        stack.pop();
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Leet_20_ValidParentheses().isValid2("(([]){})"));
    }
}
