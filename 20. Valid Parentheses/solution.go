package main

type Stack struct {
	stack []rune
}

func NewStack() *Stack {
	return &Stack{}
}

// push
func (s *Stack) push(n rune) {
	s.stack = append(s.stack, n)
}

// pop
func (s *Stack) pop() rune {
	l := len(s.stack)

	top := s.stack[l-1]
	s.stack = s.stack[:l-1]
	return top
}

// peek
func (s *Stack) peek() rune {
	return s.stack[len(s.stack)-1]
}

func isValid(s string) bool {
	reverseMapping := map[rune]rune{
		')': '(',
		'}': '{',
		']': '[',
	}

	stack := NewStack()

	for _, r := range s {
		if r == '(' || r == '{' || r == '[' {
			stack.push(r)
		} else if r == ')' || r == '}' || r == ']' {
			if len(stack.stack) == 0 {
				return false
			} else if stack.peek() == reverseMapping[r] {
				stack.pop()
			} else {
				return false
			}
		} else {
			return false
		}
	}

	return len(stack.stack) == 0
}
