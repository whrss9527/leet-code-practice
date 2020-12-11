package medium;


/**
 *
 * 面试题64. 求1+2+…+n
 * 难度
 * 中等
 *
 * 125
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 关注
 * 反馈
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 *
 * 限制：
 *
 * 1 <= n <= 10000
 */
public class _面试题64_ {
    /**
     * 解题思路：
     *      只需要用到我们中学数学中学过的等差数列求和公式
     *      Sn=n(a1+an)/2 Sn=na1+n(n-1)d/2=dn^2/2+(a1-d/2)n
     *      公式中首项为a1，末项为an，项数为n，公差为d，前n项和为Sn。
     *      这里 我们的公差 d = 1 ,a1 = 1 , an = n , 套用公式 套用公式 Sn = (n^2+n)/2
     *
     * @param n
     * @return
     */
    public static int sumNums(int n) {
       return (int) (Math.pow(n, 2) + n) >> 1;
    }
    public static int sumNums2(int n) {
        return (1+n)*n/2;
    }
    //test
    public static void main(String[] args) {
        System.out.println(sumNums(8)+"-------"+sumNums2(8));
    }
}
