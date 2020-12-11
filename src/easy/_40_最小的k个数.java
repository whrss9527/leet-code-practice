package easy;

import java.util.Arrays;

public class _40_最小的k个数 {
    /**
     * 解题思路：
     *        这道题非常简单，我们首先要做的就是给数组排序，而java官方自带有数组排序方法sort，因为官方的排序在算法上是比较优秀的，我们无需重写
     *        所以直接调用sort为数组排序，接着将数组中的前k个元素取出，返回即可
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
//        if(arr.length==0){
//            return arr;
//        }
        Arrays.sort(arr);
        int [] a = new int[k];
        for(int i = 0;i<k;i++){
            a[i]=arr[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int [] arr={};
        int [] a = getLeastNumbers(arr,0);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }

    }
}
