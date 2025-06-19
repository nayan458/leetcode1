class Solution {
    private int maxPath(TreeNode root, String type, int val) {
        if(root == null)
            return val - 1;
        switch(type) {
            case "right":
                return Math.max(
                    maxPath(root.left, "left", val + 1), 
                    maxPath(root.right, "right", 1)
                );
            case "left":
                return Math.max(
                    maxPath(root.left, "left", 1),
                    maxPath(root.right, "right", val + 1)
                );
        }
        return 0;
    }
    public int longestZigZag(TreeNode root) {
        if(root ==  null)
            return 0;
        return Math.max(
                maxPath(root.right, "right", 1),
                maxPath(root.left, "left", 1)
            );
    }
}