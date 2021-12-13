package maxIncreaseKeepingSkyline

func maxIncreaseKeepingSkyline(grid [][]int) (ans int) {
	n := len(grid)
	mm := make([]int, n)
	nm := make([]int, n)
	for i, row := range grid {
		for j, h := range row {
			mm[j] = max(h, mm[j])
			nm[i] = max(h, nm[i])
		}
	}
	for i, row := range grid {
		for j, h := range row {
			ans += min(mm[j], nm[i]) - h
		}
	}
	return
}

func max(a, b int) int {
	if b > a {
		return b
	}
	return a
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
