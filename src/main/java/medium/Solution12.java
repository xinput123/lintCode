package medium;

/**
 * 整数转罗马数字
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Solution12 {

    public String intToRoman(int num) {
        // 罗马数字
        String[] roman = {"MMM", "MM", "M",
                "CM", "DCCC", "DCC", "DC", "D", "CD", "CCC", "CC", "C",
                "XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X",
                "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        // 阿拉伯数字
        int[] arab = {3000, 2000, 1000,
                900, 800, 700, 600, 500, 400, 300, 200, 100,
                90, 80, 70, 60, 50, 40, 30, 20, 10,
                9, 8, 7, 6, 5, 4, 3, 2, 1};

        StringBuilder sb = new StringBuilder();
        // 因为罗马数字中有几个比较特殊的，所以我们直接列举出来即可,并循环一次数组即可
        // 直接从最高位按照这些数字往下减就行了，比如 1933 => 1940-1000-900-10-10-10-1-1-1
        for (int i = 0; i < arab.length; i++) {
            int arab_cur = arab[i];
            if (num < arab_cur) {
                continue;
            } else {
                sb.append(roman[i]);
                num = num - arab_cur;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        System.out.println(s.intToRoman(100));
        System.out.println(s.intToRoman(8));
        System.out.println(s.intToRoman(7));
        System.out.println(s.intToRoman(6));
        System.out.println(s.intToRoman(5));
        System.out.println(s.intToRoman(4));
        System.out.println(s.intToRoman(3));
        System.out.println(s.intToRoman(2));
        System.out.println(s.intToRoman(1));

    }
}
