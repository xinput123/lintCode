package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-03 00:51
 */
public class Leet_13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = map.get(s.charAt(0));
        /**
         * 根据罗马数字的规则：
         *  如果前面大于后面的罗马数字，则加
         *  如果小于，则减
         *  所以如果大的话，就加一次，减两次
         *
         *  IV = 1 + 5 - 2 * 1
         *  VI = 1 + 5
         *  IX = 1 + 10 - 2 * 1
         */
        for (int i = 1; i < s.length(); i++) {
            int a = map.get(s.charAt(i));
            int b = map.get(s.charAt(i - 1));
            if (i > 0 && a > b) {
                result = result + a - 2 * b;
            } else {
                result = result + a;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leet_13_RomanToInteger().romanToInt("I"));
        System.out.println(new Leet_13_RomanToInteger().romanToInt("II"));
        System.out.println(new Leet_13_RomanToInteger().romanToInt("III"));
        System.out.println(new Leet_13_RomanToInteger().romanToInt("IV"));
        System.out.println(new Leet_13_RomanToInteger().romanToInt("V"));
        System.out.println(new Leet_13_RomanToInteger().romanToInt("VI"));
        System.out.println(new Leet_13_RomanToInteger().romanToInt("LVIII"));
        System.out.println(new Leet_13_RomanToInteger().romanToInt("MCMXCIV"));
    }
}
