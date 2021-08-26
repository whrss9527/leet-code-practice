package medium;

import java.util.Arrays;

/**
 * 881. 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 * <p>
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 */
public class _881_救生艇 {

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int res = 0;
        while (left <= right) {
            if(left == right){
                res++;
                break;
            }
            else if(people[left]+people[right] > limit) {
                right--;
                res++;
            }else if(people[left]+people[right]<=limit){
                res++;
                left++;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 1, 2, 2, 3
        // [3,5,3,4]  5
        int[] arrayA = new int[]{3, 3, 4, 5};
        System.out.println(numRescueBoats(arrayA,5));
    }

}
