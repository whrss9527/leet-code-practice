package easy;

public class _859_亲密字符串 {
    /***
     * 当 s 与 goal 长度 或 词频不同，必然不为亲密字符；
     * 当 s 与 goal 不同的字符数量为 2（能够相互交换）」或s 与 goal 不同的字符数量为0，但同时 s中有出现数量超过2 的字符（能够相互交换）」时，两者必然为亲密字符。

     * @param s
     * @param goal
     * @return
     */
    public boolean buddyStrings(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (n != m) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++; cnt2[b]++;
            if (a != b) sum++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
            if (cnt1[i] > 1) ok = true;
        }
        return sum == 2 || (sum == 0 && ok);
    }

}
