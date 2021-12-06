package easy

func truncateSentence(s string, k int) string {
	len := len(s)
	end := 0
	count := 0
	for i := 0; i <= len; i++ {
		if i == len || s[i] == ' ' {
			count++
			if k == count {
				break
			}
		}
	}
	return s[:end]
}
