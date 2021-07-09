package offer;

/**
 * @author shaw
 * @describe 剑指 Offer 10- I. 斐波那契数列
 * @date 2021/07/09 14:06
 */
public class Fib {
    /**
     * 备忘录法，将每次求和的结果保存，本质也是递归
     *
     * @param n 项数
     * @return fib结果
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] list = new int[n + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i <= n; i++) {
            list[i] = list[i - 1] + list[i - 2];
            list[i] %= 1000000007;
        }
        return list[n];
    }
}
