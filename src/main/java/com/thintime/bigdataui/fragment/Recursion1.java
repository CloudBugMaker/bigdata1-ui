package com.thintime.bigdataui.fragment;

/**
 * @author Thintime
 * @create 2020/5/1
 * @desc todo 递归，方法自己调用自己
 * @remark 容易出现栈溢出：方法调用时使用栈保存运行时的状态(变量拷贝、调用地址等)，栈的存储结构是有限的，超出后会{@link StackOverflowError}
 *
 * @hint 斐波那契数列：1，1，2，3，5，8，13，21...
 * @parse 0号问题： f(0) = 0, f(1) = 1.
 *        分解：f(n-1), f(n-2)
 *        组合：f(n) = f(n-1) + f(n-2)
 */
public class Recursion1 {

    /**
     *            f(5)              1个节点
     *         /        \
     *       f(4)       f(3)        2个节点
     *       /  \       /  \
     *     f(3) f(2)  f(2) f(1)     4个节点
     *              ...               ...
     * @parse 空间复杂度：每个节点上的操作是相加求和，即O(1)，总的空间复杂度为O(n)
     *        时间复杂度：1 + 2 + 4 + 8 + ... = 2^n-1 ≈ 2^n
     * @remark 太多的重复计算
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    /** 优化算法
     * @parse 使用数组记录f(0) ~ f(n-1)的值
     */
    public static int fib2(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[n] = arr[n - 1] + arr[n - 2];
        }
        return arr[n];
    }

    /** 进一步优化
     * @desc 动态规划DP = Recursion + Cache
     * 空间复杂度：O(1)
     */
    public static int fib3(int n) {
        int a = 0; int b = 1;
        if (n==0) return a;
        if (n==1) return b;
        for (int i = 2; i <=n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    /**
     * @hint 一个 N 阶的楼梯，每次能走一层或者两层，问一共有多少种走法
     * @parse f(n) = f(n-1) + f(n-2)，f(1) = 1，f(2) = 2
     */
}
