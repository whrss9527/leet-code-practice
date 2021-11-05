package medium;

import java.util.HashMap;

public class _1218_最长定差子序列 {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for(int x: arr){
            dp.put(x, dp.getOrDefault(x-difference,0)+1);
            ans = Math.max(ans,dp.get(x));
        }
        return ans;
    }
}
