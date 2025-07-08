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
    List<Integer> q;
    private static int i;
    private static int size = 0;

    public BSTIterator(TreeNode root) {
        q = new ArrayList<>();
        inorder(root);
        i = 0;
        size = q.size();
    }
    
    public int next() {
        if(hasNext())
            return q.get(i++);
        return -1;
    }
    
    public boolean hasNext() {
        System.out.printf("i: %d,\tsize: %d",i,size);
        return i < size;
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        q.add(root.val);
        inorder(root.right);

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
//     Queue<TreeNode> q;

//     public BSTIterator(TreeNode root) {
//         q = new LinkedList<>();
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