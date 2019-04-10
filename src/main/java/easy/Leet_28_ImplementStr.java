package easy;

/**
 * Implement strStr()
 * <p>
 * 返回haystack中第一次出现针的索引，如果针不是haystack的一部分，则返回-1。
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-04-10 00:08
 */
public class Leet_28_ImplementStr {
    public int strStr(String haystack, String needle) {
        return indexOf(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.toCharArray().length);
    }

    static int indexOf(char[] source, int sourceCount,
                       char[] target, int targetCount) {
        if (0 >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }

        if (targetCount == 0) {
            return 0;
        }

        char first = target[0];
        int max = sourceCount - targetCount;

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) {
                }
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++) {
                }

                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }
}
