package main

func levelOrder(root *TreeNode) [][]int {
	var levels [][]int

	if root == nil {
		return levels
	}

	thisLevel := []*TreeNode{root}

	for {
		var nextLevel []*TreeNode
		var level []int
		for _, node := range thisLevel {
			if node.Left != nil {
				nextLevel = append(nextLevel, node.Left)
			}

			if node.Right != nil {
				nextLevel = append(nextLevel, node.Right)
			}

			level = append(level, node.Val)
		}

		levels = append(levels, level)

		if len(nextLevel) == 0 {
			return levels
		} else {
			thisLevel = nextLevel
		}
	}
}
