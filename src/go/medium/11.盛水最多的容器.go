package medium

func maxArea(height []int) int {
	res := 0
	for i, j := 0, len(height); i < j; {
		minHeight := 0
		if height[j] > height[i] {
			minHeight = height[i]
			i++
		} else {
			minHeight = height[j]
			j--
		}
		area := (j - i + 1) * minHeight
		res = max(area, res)
	}
	return res
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
