class Solution {

    private int max  = 0;
    private int level = 1;

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        int curr_level = 1;
        this.max = root.val;

        if(root == null) return 0;
        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if(node == null) {
                if(max < sum){
                    max = sum;
                    level = curr_level;
                }
                curr_level++;
                sum = 0;
                if (!q.isEmpty())
                    q.offer(null);
                continue;
            }
            sum += node.val;
            if(node.left != null)   q.offer(node.left);
            if(node.right != null)  q.offer(node.right);
        }
        return level;
    }
}