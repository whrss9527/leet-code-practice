package easy

func distributeCandies(candyType []int) int {
	// 创建一个map
	set := map[int]struct{}{}
	// 遍历数组中的数，去重放在map中
	for _, t := range candyType {
		set[t] = struct{}{}
	}
	// 比较种类多还是能取的糖果多，取少的那个返回。
	ans := len(candyType) / 2
	if len(set) < ans {
		ans = len(set)
	}
	return ans
}
