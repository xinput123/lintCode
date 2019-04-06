package easy;

/**
 * 最长的共同前缀
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-03 00:51
 */
public class Leet_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 假设第一个字符串就是最大长度
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 将当前最长共同字符串和当前数组中的对比,把小的那个作为长度
            int len = prefix.length() > strs[i].length() ? strs[i].length() : prefix.length();
            int j = 0;
            for (j = 0; j < len; j++) {
                // 逐个字符比较，不等的时候退出
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            // 退出的j即当前的最小,整个遍历结束后就是整个的最小了
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
