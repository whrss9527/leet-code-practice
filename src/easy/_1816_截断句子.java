package easy;

public class _1816_截断句子 {
    public String truncateSentence(String s, int k) {
        int len = s.length();
        int end = 0, count = 0;
        for (int i = 1; i <= len; i++) {
            if (i == len || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }
}
