class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        
        nodeQueue.offer(root);
        indexQueue.offer(1);
        
        int maxWidth = 0;
        
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            int leftIndex = 0, rightIndex = 0;
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeQueue.poll();
                int index = indexQueue.poll();
                
                // First node of level sets left boundary
                if (i == 0) leftIndex = index;
                // Last node of level sets right boundary  
                if (i == levelSize - 1) rightIndex = index;
                
                // Add children for next level
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            
            // Calculate width of current level
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }
        
        return maxWidth;
    }
}