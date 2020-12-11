package easy;

import java.util.*;

/**
 * @author wuhao
 * @date 2020/11/2 15:24
 */
public class _349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> eliminateRepeat = new HashSet<>(); // 防止重复
        List<Integer> list = new LinkedList<>();
        //将nums1放入set集合中（去重）
        for(int i = 0;i < nums1.length;i++) {
            set.add(nums1[i]);
        }
        //判断nums1中已经去重的元素是否包含nums2中的元素，并将它添加到另一个set中和另一个list中。
        //如果另一个set中已经存在该元素，eliminateRepeat.add(nums2[i])将返回false，将不添加至list中。
        for(int i = 0;i < nums2.length;i++){
            if(set.contains(nums2[i]) && eliminateRepeat.add(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        //将最后list中的元素转换成数组，返回
        int[] result = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
