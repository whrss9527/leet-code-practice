package easy;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

 示例1:

 输入："aabcccccaaa"
 输出："a2b1c5a3"
 示例2:

 输入："abbccd"
 输出："abbccd"
 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 提示：

 字符串长度在[0, 50000]范围内。


 */
class _字符串压缩 {
    public static String compressString(String S) {
        if(S==null||S.length()==0){
           return S;
        }
        char [] ss = S.toCharArray();
        char next = S.charAt(0);

        StringBuilder string = new StringBuilder();
        string.append(next);
        int count = 1;

        for(int i=1;i<ss.length;i++){

            char cur = S.charAt(i);

            if(ss[i]==next){
                count++;
                if(i==ss.length-1){
                    string.append(count);
                }
            }else{

                next=cur;

                string.append(count).append(next);
                if(i==ss.length-1){
                    string.append(1);
                }
                count=1;


            }

        }
        if(S.length()<=string.toString().length()){
            return S;
        }
        return string.toString();
    }

    public static void main(String[] args) {
        String s = compressString("IIIIeeeeOODDDssppppooQQQQppplllhU");
        System.out.println(s);
    }
}