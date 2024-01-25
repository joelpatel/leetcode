var levelOrder = function(root) {
    let levels = [];
    
    if (isNil(root)) {
       return levels; 
    }

    let thisLevel = [root];

    while(true) {
        let nextLevel = [];
        let level = [];

        for (const node of thisLevel) {
            if (!isNil(node.left)) {
             nextLevel.push(node.left);
            }
    
            if (!isNil(node.right)) {
             nextLevel.push(node.right);
            }
    
            level.push(node.val);
        }

        levels.push(level);

        if (nextLevel.length === 0) {
            return levels
        } else {
            thisLevel = nextLevel;
        }
    }
}