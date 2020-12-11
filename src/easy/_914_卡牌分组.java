package easy;



/**
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 * 提示：
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _914_卡牌分组 {
    /**
     * 解题思路：
     *      首先，本题的题意容易理解，但想要思考全面很难，所以要找出题目真正需要你去找的算法是什么?
     *      1、给一个int数组，找到这个数组中大于等于2的数，把所有的数按这个数来分组（每组有这么多个）;
     *      2、另一种说法：将这个数组分组，每组数字个数相等且大于2。
     *      那么，我们所要做的就是把这个数组中的数字量进行统计，然后进行处理校验，如何做呢？
     *      1、我们需要拿出每个数和它出现的次数;
     *      2、对数字逐个进行辗转相除;
     *      3、(什么是辗转相除呢，就是求两个数的最大公约数);
     *      4、通过辗转相除，求出所有“个数”中的最大公约数，如果最后得到的最大公约数为1，则返回false。
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {

        // 计数
        int[] counter = new int[10000];
        for (int num: deck) {
            counter[num]++;
        }
        // 求所有数的最大公约数
        int x = 0;
        for(int cnt: counter) {
            if (cnt > 0) {
                x = gcd(x, cnt);
                System.out.println(x);
                if (x == 1) {
                    return false;
                }
            }
        }
        System.out.println(x);
        return x >= 2;
    }

    // 辗转相除法,得到 a 和 b 的最大公约数。
    private static int gcd (int a, int b) {
        return b == 0? a: gcd(b, a % b);

    }



    public static void main(String[] args) {
        int [] deck = {4,8,8,4,88};
        System.out.println("结果为："+hasGroupsSizeX(deck));
        //       System.out.println("结果为："+gcd(4,8));

    }

}
