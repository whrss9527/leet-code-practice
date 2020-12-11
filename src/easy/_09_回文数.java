package easy;


import java.util.Stack;


/**
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _09_回文数 {
    public static boolean isPalindrome(int x) {
        //如果是负数 直接返回
        if(x<0) return false;
        //如果是个位数 直接返回
        if(x<10) return true;
        //将该数字转化为字符串
        String s = Integer.toString(x);
        //新建一个栈（后进先出）
        Stack v = new Stack();
        //定义字符串长度的变量，后面会频繁用到
        int length = s.length();
        //如果字符串长度为奇数，剔除中间元素
        if(length%2!=0) s=s.substring(0, length/2)+s.substring(length/2+1);
        //将第一个元素直接入栈
        v.push(s.charAt(0));
        //开始循环遍历字符串
        for(int i = 1;i<length;i++){
            //如果遍历过半，则进行判断进行出栈操作
            if(i+1>length/2){
                //如果栈顶元素与当前元素相同，则出栈
                if(v.peek().equals(s.charAt(i))){
                    v.pop();
                }else {
                    return false;
                }
            //若遍历未过半，则继续将元素添加进栈
            }else{
                v.push(s.charAt(i));
            }
        }
        if(v.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    //test
    public static void main(String[] args) {
        System.out.println(isPalindrome(11));
    }
}
