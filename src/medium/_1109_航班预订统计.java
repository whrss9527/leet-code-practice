package medium;

/***
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，其中 answer[i] 是航班 i 上预订的座位总数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 *
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 *
 *
 * 提示：
 *
 * 1 <= n <= 2 * 104
 * 1 <= bookings.length <= 2 * 104
 * bookings[i].length == 3
 * 1 <= firsti <= lasti <= n
 * 1 <= seatsi <= 104
 */
public class _1109_航班预订统计 {
    /***
     * 暴力解法
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int []answer = new int[n];
        for (int i = 0; i < bookings.length; i++){
           int start = bookings[i][0];
           int end = bookings[i][1];
           int num = bookings[i][2];
           for (int j = start; j <= end; j++){
               answer[j-1]+=num;
           }
        }
        return answer;
    }

    /****
     * 官方：差分
     * 注意到一个预订记录实际上代表了一个区间的增量。我们的任务是将这些增量叠加得到答案。因此，我们可以使用差分解决本题。
     *
     * 差分数组对应的概念是前缀和数组，对于数组 [1,2,2,4][1,2,2,4]，其差分数组为 [1,1,0,2][1,1,0,2]，差分数组的第 ii 个数即为原数组的第 i-1i−1 个元素和第 ii 个元素的差值，也就是说我们对差分数组求前缀和即可得到原数组。
     *
     * 差分数组的性质是，当我们希望对原数组的某一个区间 [l,r][l,r] 施加一个增量\textit{inc}inc 时，差分数组 dd 对应的改变是：d[l]d[l] 增加 \textit{inc}inc，d[r+1]d[r+1] 减少 \textit{inc}inc。这样对于区间的修改就变为了对于两个位置的修改。并且这种修改是可以叠加的，即当我们多次对原数组的不同区间施加不同的增量，我们只要按规则修改差分数组即可。
     *
     * 在本题中，我们可以遍历给定的预定记录数组，每次 O(1)O(1) 地完成对差分数组的修改即可。当我们完成了差分数组的修改，只需要最后求出差分数组的前缀和即可得到目标数组。
     *
     * 注意本题中日期从 11 开始，因此我们需要相应的调整数组下标对应关系，对于预定记录 \textit{booking}=[l,r,\textit{inc}]booking=[l,r,inc]，我们需要让 d[l-1]d[l−1] 增加 \textit{inc}inc，d[r]d[r] 减少 \textit{inc}inc。特别地，当 rr 为 nn 时，我们无需修改 d[r]d[r]，因为这个位置溢出了下标范围。如果求前缀和时考虑该位置，那么该位置对应的前缀和值必定为 00。读者们可以自行思考原因，以加深对差分数组的理解。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings/solution/hang-ban-yu-ding-tong-ji-by-leetcode-sol-5pv8/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
