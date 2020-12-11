package difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuhao
 * @date 2020/11/4 17:04
 *
 *57. 插入区间
 * 难度
 * 困难
 *
 * 281
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 */
public class _57_插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //一个头指针
        int left = newInterval[0];
        //一个尾指针
        int right = newInterval[1];
        int len = intervals.length;
        //标志位，为了将相交区间能够顺序加入区间返回，false表示该区间还未加入返回结果
        boolean flag = false;
        //用list做容器暂存返回结果
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < len ; i++) {
            if(intervals[i][1]<left){
                l.add(intervals[i]);
            }else if(intervals[i][0]>right){
                //这个判断要放在前面，这样才能顺序加入
                if(!flag){
                    //添加完之后，将flag改为true
                    l.add(new int[]{left,right});
                    flag=true;
                }
                l.add(intervals[i]);
            }else{
                //以范围更大的为准
                left = Math.min(intervals[i][0],left);
                right = Math.max(intervals[i][1],right);
            }
        }
        //如果到最后，还未加入，则说明区间在最后
        if (!flag){
            l.add(new int[]{left,right});
        }

        int res[][] = new int[l.size()][2];
        for(int j=0;j<l.size();j++){
            res[j]=l.get(j);
        }
        return res;
    }
}
