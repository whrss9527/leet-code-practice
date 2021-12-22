package findRadius

import (
	"sort"
)

//1. 对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
//2. 对于所有的房屋，选择最大的上述距离。
func findRadius(houses []int, heaters []int) int {
	sort.Ints(houses)
	sort.Ints(heaters)
	ans := 0
	j := 0
	for i := 0; i < len(houses); i++ {
		distance := abs(houses[i] - heaters[j])
		for j < len(heaters)-1 && abs(houses[i]-heaters[j+1]) <= distance {
			j++
			distance = abs(houses[i] - heaters[j])
		}
		if ans < distance {
			ans = distance
		}
	}
	return ans
}
func abs(b int) int {
	if b < 0 {
		return -b
	}
	return b
}
