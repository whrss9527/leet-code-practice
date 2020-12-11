package medium;

import java.util.Arrays;

/**
 * 378. 有序矩阵中第K小的元素
 * 难度
 * 中等
 *
 * 312
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 关注
 * 反馈
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 */
public class _378_有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {

        int leny = matrix.length;
        int lenx = matrix[0].length;
        int capacity[] = new int[lenx*leny];
        int num = 0;
        for(int i = 0;i<leny;i++){
            for (int j = 0;j<lenx;j++){
                capacity[num] = matrix[i][j];
                num++;
            }
        }
        Arrays.sort(capacity);
        return capacity[k-1];
    }
}
