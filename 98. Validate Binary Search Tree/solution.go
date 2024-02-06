package main

func isValidBST(root *TreeNode) bool {
	return validate(root, nil, nil)
}

func validate(root, min, max *TreeNode) bool {
	if root == nil {
		return true
	}

	if min != nil && root.Val <= min.Val {
		return false
	}

	if max != nil && root.Val >= max.Val {
		return false
	}

	return validate(root.Left, min, root) && validate(root.Right, root, max)
}
