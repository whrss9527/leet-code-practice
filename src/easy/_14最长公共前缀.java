package easy;

public class _14最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String s = strs[0];
        for(int i=1;i<strs.length;i++){
            while (strs[i].indexOf(s)!=0){
                s=s.substring(0, s.length()-1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String [] arr = {"aaa","aab","av"};
        System.out.println("最长的前缀"+longestCommonPrefix(arr));
    }
}
