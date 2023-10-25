package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	input := []string{"32#howdy", "wor%45#world"}

	encoded := encode(input)
	output := decode(encoded)

	status := true
	if len(input) == len(output) {
		for i := 0; i < len(input); i++ {
			status = status && (input[i] == output[i])
		}
	} else {
		status = false
	}

	fmt.Println(status)
	fmt.Println(input)
	fmt.Println(output)
}

func encode(strs []string) string {
	builder := strings.Builder{}
	defer builder.Reset()

	for _, str := range strs {
		builder.WriteString(strconv.Itoa(len(str)))
		builder.WriteRune('#')
		builder.WriteString(str)
	}
	return builder.String()
}

func decode(str string) []string {
	var output []string
	i := 0

	for i < len(str) {
		j := i
		for str[j] != '#' {
			j++
		}

		length, _ := strconv.Atoi(str[i:j])
		i = j + 1 + length
		output = append(output, str[j+1:i])
	}
	return output
}
