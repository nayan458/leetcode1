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
class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    public int next() {
        if(hasNext()){
            TreeNode node = st.pop();
            pushLeft(node.right);
            return node.val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushLeft(TreeNode root){
        if(root == null)
            return;
        st.push(root);
        pushLeft(root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class BSTIterator {
//     private Queue<TreeNode> q = new LinkedList<>();

//     public BSTIterator(TreeNode root) {
//         inorder(root);
//     }
    
//     public int next() {
//         if(hasNext())
//             return q.poll().val;
//         return -1;
//     }
    
//     public boolean hasNext() {
//         return !q.isEmpty();
//     }

//     private void inorder(TreeNode root){
//         if(root == null)
//             return;
//         inorder(root.left);
//         q.add(root);
//         inorder(root.right);

//     }
// }

// /**
//  * Your BSTIterator object will be instantiated and called as such:
//  * BSTIterator obj = new BSTIterator(root);
//  * int param_1 = obj.next();
//  * boolean param_2 = obj.hasNext();
//  */