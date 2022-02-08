package pivotArray

func pivotArray(nums []int, pivot int) []int {
	// 分三截 最后拼接
	var a, b, c []int
	for _, v := range nums {
		if v < pivot {
			a = append(a, v)
		} else if v == pivot {
			b = append(b, v)
		} else {
			c = append(c, v)
		}
	}
	return append(append(a, b...), c...)
}
