package easy;

public class _495_提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        //记录艾希恢复为未中毒的起始时间 expired
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return ans;
    }
}
