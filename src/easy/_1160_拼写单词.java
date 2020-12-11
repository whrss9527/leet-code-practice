package easy; /**
 * 1160. 拼写单词
 难度
 简单

 49

 收藏

 分享
 切换为英文
 关注
 反馈
 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

 注意：每次拼写时，chars 中的每个字母都只能用一次。

 返回词汇表 words 中你掌握的所有单词的 长度之和。



 示例 1：

 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 输出：6
 解释：
 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 示例 2：

 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 输出：10
 解释：
 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。


 提示：

 1 <= words.length <= 1000
 1 <= words[i].length, chars.length <= 100
 所有字符串中都仅包含小写英文字母
 */

/**
 * 本题采用最简单的解法，在性能上并不是那么优秀，主要对逻辑和数据结构进行练习
 * 解题思路：
 *         本题要求从chars中拿到所有的字符，看words中有哪些字符串是chars中的字符组成的，然后返回总长度。
 *         1、首先，我们需要一个存储符合条件字符串的对象 StringBuilder ，用来存储满足条件的字符串；
 *         2、利用循环遍历所有的字符串，在其中寻找符合条件的字符串并将其累加在 Stringbuild 上；
 *         3、利用循环，把某一字符串中用到的所有字符一一和字典中的字符进行比对，含有就先将字典中的该字符去除，若有一个字符是字典中不存在的，这该字符串不满足条件，break；
 *         4、最后将得到的结果拿到长度返回。
 */
public class _1160_拼写单词 {
    public static int countCharacters(String[] words, String chars) {
        if(words==null||words.length==0||chars==""||chars==null){
            return 0;
        }
        StringBuilder s = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String c = chars;
            for(int j =0;j<words[i].length();j++){
                if(c.indexOf(words[i].charAt(j))>=0){
                    c=c.substring(0,c.indexOf(words[i].charAt(j)))+c.substring(c.indexOf(words[i].charAt(j))+1,c.length());
                    if(j==words[i].length()-1){
                        s.append(words[i]);
                    }
                }else{
                    break;
                }
            }
        }

        return s.length();

    }

    public static void main(String[] args) {
        String [] w = {"ab","abc","ac"};
        System.out.println(countCharacters(w,"abc"));
    }
}
