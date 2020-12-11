package easy;
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _07整数反转 {
    public static int reverse(int x) {
        if(x==-2147483648){
            return 0;
        }
        boolean isF =false;
        if(x<0){
            x=-x;
            isF=true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String xx = ""+x;
        System.out.println(xx);
        int length = xx.length()-1;
        System.out.println(length);
        for(int i=length;i>=0;i--){
            if(i==length&&xx.charAt(i)==0){

                length--;
                continue;
            }
            stringBuilder.append(xx.charAt(i));
        }

        Long l = Long.parseLong(stringBuilder.toString());
        Long F = 2147483648L;
        Long Z = 2147483647L;

        if(isF){
           if(l>F){
               return 0;
           }
           int s = Integer.parseInt(stringBuilder.toString());
           return -s;
        }else {
            if(l>Z){
                return 0;
            }
            int s = Integer.parseInt(stringBuilder.toString());
            return s;
        }

    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483647));
    }
}
