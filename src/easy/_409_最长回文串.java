package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 难度
 简单

 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

 注意:
 假设字符串的长度不会超过 1010。

 示例 1:

 输入:
 "abccccdd"

 输出:
 7

 解释:
 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。


 */
public class _409_最长回文串 {
    /**
     * 解题思路：
     *        1、创建一个map，用来存储字符出现的次数，key为字符 value为次数
     *        2、遍历字符串，如果该字符串已经出现过就+1，没有出现过就新加记录
     *        3、最后进行统计，单个字符出现的次数，字符为单数个的情况 出现一次或者不出现不影响最后结果，若大于一次，则就要根据出现的次数做相应的减法
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(m.get(s.charAt(i))==null){
                m.put(s.charAt(i), 1);
            }else{
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            }

        }
        int mc = 0;
        for (Character key : m.keySet()) {
            if (m.get(key) % 2 == 1) {
                mc++;
            }

        }
        if(mc<=1){
            return s.length();
        }
        return s.length()-mc+1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
