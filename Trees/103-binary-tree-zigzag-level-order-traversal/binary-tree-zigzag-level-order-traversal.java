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
    private Stack<TreeNode> stEven = new Stack<>();
    private Stack<TreeNode> stOdd = new Stack<>();
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> level = new ArrayList<>();

    private void odd(){
        level = new ArrayList<>();
        while(!stEven.isEmpty()){
            TreeNode temp = stEven.pop();
            if(temp.left != null)
                stOdd.push(temp.left);
            if(temp.right != null)
                stOdd.push(temp.right);
            level.add(temp.val);
        }
        if(level.size() > 0)
            ans.add(level);
    }

    private void even(){
        level = new ArrayList<>();
        while(!stOdd.isEmpty()){
            TreeNode temp = stOdd.pop();
            if(temp.right != null)
                stEven.push(temp.right);
            if(temp.left != null)
                stEven.push(temp.left);
            level.add(temp.val);
        }
        if(level.size() > 0)
            ans.add(level);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null )
            return ans;

        stEven.push(root);

        while(!stEven.isEmpty() || !stOdd.isEmpty()) {
            odd();
            even();
        }
        return ans;
    }
}