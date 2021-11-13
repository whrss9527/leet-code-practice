package easy

import "unicode"

func detectCapitalUse(word string) bool {
	if len(word) >= 2 && unicode.IsLower(rune(word[0])) && unicode.IsUpper(rune(word[1])) {
		return false
	}
	for i := 2; i < len(word); i++ {
		if unicode.IsLower(rune(word[1])) && unicode.IsUpper(rune(word[i])) || unicode.IsUpper(rune(word[1])) && unicode.IsLower(rune(word[i])) {
			return false
		}
	}
	return true
}
