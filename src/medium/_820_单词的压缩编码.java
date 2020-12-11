package medium;

import java.util.Arrays;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *  
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *  
 *
 * 提示：
 *
 * 1、       1 <= words.length <= 2000
 * 2、       1 <= words[i].length <= 7
 * 3、       每个单词都是小写字母 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _820_单词的压缩编码 {

    public static int minimumLengthEncoding(String[] words) {

        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());

        String[] temp = new String[words.length];
        for(int i=0; i<words.length; i++){
            String m = words[i]+"#";
            temp[i] = m;
        }

        String result = "" ;
        for(int i=0; i<temp.length; i++){
            if(!result.contains(temp[i]))
                result = result+temp[i];
        }
        return result.length();
    }

    public static void main(String[] args) {
        String s[] = {"me","time","ti"};
        System.out.println(minimumLengthEncoding(s));
    }
}
