package medium;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _03_无重复的最长字符串 {

    public static int lengthOfLongestSubstring(String s) {

        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(0));
        int l = 0;
        for(int i=1;i<s.length();i++){


            for(int j=0;j<stringBuilder.length();j++){
                if(stringBuilder.charAt(j)==s.charAt(i)){

                    StringBuilder stringBuilder2 = new StringBuilder();
                    for(int x = i-1;x>=0;x--){
                        if(s.charAt(i)==s.charAt(x)){
                            stringBuilder2.append(s.substring(x+1,i+1));
                            break;
                        }
                    }
                    stringBuilder=stringBuilder2;
                    l = (stringBuilder.length()>l)?stringBuilder.length():l;
                    break;

                }else if(j==stringBuilder.length()-1){
                    stringBuilder.append(s.charAt(i));
                    l = (stringBuilder.length()>l)?stringBuilder.length():l;
                    break;
                }
            }
        }
        return l;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
