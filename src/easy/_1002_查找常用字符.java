package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 * 难度
 * 简单
 *
 * 201
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class _1002_查找常用字符 {

    /**
     * 思路： 本题含义即 取所有元素的交集，返回
     *          所以，我们的解题一定要经历过A.length的比较将共同的字符串取出
     *          1、由于题目中规定 A[i][j] 是小写字母 ， 那么我们可以建立一个内长度为26的二维数组，用以迭代每次的比较结果。
     *          2、到数组最后一个元素，我们就会将所有元素的交集存放在[A.length-1][i]中。
     *          3、遍历第A.length-1，并按值的大小去取对应数量的值即可
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        int map[][] = new int[A.length][26];
        for (int i = 0; i < A.length; i++)
        {
            if (i == 0){
                for (char c : A[0].toCharArray())
                {
                    map[0][c - 'a'] = map[0][c - 'a'] + 1;
                }
            }
            else
            {
                for (char c : A[i].toCharArray())
                {
                    map[i][c - 'a'] = Math.min(map[i][c - 'a'] + 1, map[i-1][c - 'a']);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (map[A.length - 1][i]>0)
            {
                while(map[A.length - 1][i]-- > 0){
                    res.add(String.valueOf((char)(i + 'a')));
                }
            }
        }
        return res;
    }
}
