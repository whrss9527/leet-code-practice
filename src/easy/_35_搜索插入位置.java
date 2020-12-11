package easy;

/**
 * @author wuhao
 * @date 2020/9/3 17:56
 */
public class _35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        int i=0;
        int len = nums.length;
       while (i<len){
           if(nums[i]>=target){
               return i;
           }
           i++;
       }
        return len;
    }
}
