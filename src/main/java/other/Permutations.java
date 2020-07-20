package other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 排列组合
 */
public class Permutations {
    // 求排列数 A(n,m) n>m
    public static int A(int n, int m) {
        int result = 1;
        // 循环m次,如A(6,2)需要循环2次，6*5
        for (int i = m; i > 0; i--) {
            result *= n;
            n--;// 下一次减一
        }
        return result;
    }

    // 求组合数，这个也不需要了。定义式，不使用互补率
    public static int C2(int n, int m) {
        // int denominator=factorial(up);//分母up的阶乘
        // 分母
        // A(6,6)就是求6*5*4*3*2*1,也就是求6的阶乘
        int denominator = A(m, m);
        // 分子
        int numerator = A(n, m);// 分子的排列数
        return numerator / denominator;
    }

    public static int C(int n, int m)// 应用组合数的互补率简化计算量
    {
        int helf = n / 2;
        if (m > helf) {
            System.out.print(m + "---->");
            m = n - m;
            System.out.print(m + "\n");
        }
        // 分子的排列数
        int numerator = A(n, m);
        // 分母的排列数
        int denominator = A(m, m);
        return numerator / denominator;
    }

    public static void main(String[] args) {
        String[] array = new String[]{"1", "2", "3", "4", "5"};
        listAll(Arrays.asList(array), "");
    }

    public static void listAll(List candidate, String prefix) {
        if (prefix.length() == 5) {
            System.out.println(prefix);
        }
        for (int i = 0; i < candidate.size(); i++) {
            List tmp = new LinkedList(candidate);
            listAll(tmp, prefix + tmp.remove(i));//函数中的参数从右边开始解析
        }
    }

}
