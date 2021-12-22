package medium;

import java.util.Arrays;

public class _475_供暖器 {
    public int findRadius(int[] houses, int[] heaters) {
        // 排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            //拿到 当前的节点 和 指定节点的供暖器 的距离
            int curDistance = Math.abs(houses[i] - heaters[j]);
            // 如果 下一个供暖器离该节点更近一些，挪动到下一个节点
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
