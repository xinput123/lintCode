package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小s顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class Solution69 {
    public String getPermutation(int n, int k) {
        List<String> getList = getList(n);
        if (k > length(n)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // 表示总共有几位
        while (n > 0) {
            if (n == 1) {
                sb.append(getList.get(0));
                return sb.toString();
            }
            // 每次先取最高位的数字
            int slience = length(n - 1);
            // 取的数组中的K个位置的数据,如果n=4，k=1到6，则最高位是数据中的第0位，即1，取出数据后，
            // 所有数据减1，集合中取出的数据应该要移除出去，n本来是4，这是要变成3，数组中4位也变成了3位，继续循环下一次操作
            int j = k / slience;
            // 取余数，即下一次的k值
            k = k % slience;
            if (k == 0) {
                j = j - 1;
                k = slience;
            }

            // 集合中要移除当前位置的数据
            String value = getList.remove(j);
            sb.append(value);

            // n -1 是为了定位下次的k的值
            n = n - 1;
        }

        return sb.toString();
    }

    public int length(int num) {
        int multiply = 1;
        while (num >= 1) {
            multiply = multiply * num;
            num = num - 1;
        }

        return multiply;
    }

    public List<String> getList(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }

        return list;
    }

    public static void main(String[] args) {
        // 12345106897
        String string = new Solution69().getPermutation(3, 3);
        System.out.println(string);
    }

}
