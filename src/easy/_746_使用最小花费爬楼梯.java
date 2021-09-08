package easy;

public class _746_使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        int []record = new int[cost.length + 1];
        // record[0] 对标 cost[1]
        record[0] = 0;
        record[1] = 0;
        for (int i = 2;i <= cost.length; i++){
            record[i] = Math.min(record[i-1]+cost[i-1],record[i-2]+cost[i-2]);
        }
        return record[cost.length];
    }



}
