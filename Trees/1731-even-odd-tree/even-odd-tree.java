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
    private boolean flag = true;

    private boolean odd(){
        while(!stEven.isEmpty()){
            TreeNode temp = stEven.pop();
            if(temp.left != null){
                if(temp.left.val % 2 != 0 || (!stOdd.isEmpty() && stOdd.peek().val <= temp.left.val))
                    return false;
                stOdd.push(temp.left);
            }
            if(temp.right != null){
                if(temp.right.val % 2 != 0 || (!stOdd.isEmpty() && stOdd.peek().val <= temp.right.val))
                    return false;
                stOdd.push(temp.right);
            }
        }
        return true;
    }

    private boolean even(){
        while(!stOdd.isEmpty()){
            TreeNode temp = stOdd.pop();
            if(temp.right != null){
                if(temp.right.val % 2 == 0 || (!stEven.isEmpty() && stEven.peek().val <= temp.right.val))
                    return false;
                stEven.push(temp.right);
            }
            if(temp.left != null){
                if(temp.left.val % 2 == 0 || (!stEven.isEmpty() && stEven.peek().val <= temp.left.val))
                    return false;
                stEven.push(temp.left);
            }
        }
        return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
        if(root == null)   
            return true;
        if(root.val % 2 == 0)
            return false;
        stEven.push(root);
        while(!stEven.isEmpty() || !stOdd.isEmpty()){
            if(!odd())
                return false;
            if(!even())
                return false;
        }
        return true;
    }
}