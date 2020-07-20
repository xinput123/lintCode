package other;

import org.junit.Test;

/**
 * 程序优化的最核心的思路
 * 第一步，暴力解法。在没有任何时间、空间约束下，完成代码任务的开发
 * 第二步，无效操作处理。将代码中的无效计算、无效存储剔除，降低时间或空间复杂度
 * 第三步，时空转换。设计合理数据结构，完成时间复杂度向空间复杂度的转移。
 * <p>
 * 假设有任意多张面额为 2 元、3 元、7 元的货币，现要用它们凑出 100 元，求总共有多少种可能性
 */
public class S2_1 {

    @Test
    public void S2_1_1() {
        int count = 0;
        for (int i = 0; i <= (100 / 7); i++) {
            for (int j = 0; j <= (100 / 3); j++) {
                for (int k = 0; k <= (100 / 2); k++) {
                    if (i * 7 + j * 3 + k * 2 == 100) {
                        count += 1;
                    }
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 去除无效操作处理
     */
    @Test
    public void S2_1_2() {
        int count = 0;
        for (int i = 0; i <= (100 / 7); i++) {
            for (int j = 0; j <= (100 / 3); j++) {
                if ((100 - i * 7 - j * 3) >= 0 && (100 - i * 7 - j * 3) % 2 == 0) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
