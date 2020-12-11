package difficulty;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：
 *
 * 可以写成某个字符串与其自身相连接的形式（即，可以写为 a + a，其中 a 是某个字符串）。
 * 例如，abcabc 就是 abc 和它自身连接形成的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：text = "abcabcabc"
 * 输出：3
 * 解释：3 个子字符串分别为 "abcabc"，"bcabca" 和 "cabcab" 。
 * 示例 2：
 *
 * 输入：text = "leetcodeleetcode"
 * 输出：2
 * 解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-echo-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1316_不同的循环子字符串 {
    /**
     * 解题思路：
     *      使用hashset的不可重复特性来解决
     *      使用 一个指针、一个长度(l) 来对字符串进行遍历，指针的位置范围根据长度来进行调整 l<  <length-l
     *      把指针之前的一段取出来与指针之后的一段进行对比，符合条件（相同）则将该半段存入set中
     *      最后返回set中的字符串数量即可
     * @param text
     * @return
     */
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= text.length() / 2; i++) {
            for (int j = i; j <= text.length() - i; j++) {
                if (text.substring(j, j + i).equals(text.substring(j - i, j))) {
                    set.add(text.substring(j, j + i));
                }
            }
        }
        return set.size();
    }
}
