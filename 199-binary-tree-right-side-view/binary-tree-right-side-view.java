/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // odd even stack
    Queue<TreeNode> q = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        q.add(root);
        q.add(null);

        while(!q.isEmpty() && q.peek() != null){
            TreeNode ptr = q.remove();

            if(ptr.left != null)
                q.add(ptr.left);
            if(ptr.right != null)
                q.add(ptr.right);

            if(q.peek() == null){
                ans.add(ptr.val);
                q.remove();
                q.add(null);
            }
        }
        return ans;
    }
    
}