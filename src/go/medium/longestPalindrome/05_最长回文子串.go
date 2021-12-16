package longestPalindrome

func longestPalindrome(s string) string {
	if len(s) < 2 {
		return s
	}

	dp := make([][]bool, len(s))
	for i := 0; i < len(s); i++ {
		dp[i] = make([]bool, len(s))
	}

	ans := ""
	for i := 0; i < len(s); i++ {
		for k := 0; k <= i; k++ {
			dp[i][k] = s[i] == s[k] && (i-1 < k+1 || dp[i-1][k+1])
			if dp[i][k] && i-k+1 > len(ans) {
				ans = s[k : i+1]
			}
		}
	}
	return ans
}
