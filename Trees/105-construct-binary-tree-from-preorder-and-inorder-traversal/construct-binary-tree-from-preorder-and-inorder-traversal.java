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
    private Map<Integer, Integer> mp = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = IntStream.range(0, inorder.length)
            .boxed()
            .collect(Collectors.toMap(
                i -> inorder[i],
                i -> i,
                (a,b) -> a
            ));
        System.out.println(mp);
        return buildTreeHelper(
            preorder, inorder, 
            0, preorder.length - 1, 
            0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
            
        int r = mp.get(preorder[preStart]);
        TreeNode root = new TreeNode(inorder[r]);

        int leftTreeSize = r - inStart;
        

        root.left = buildTreeHelper(
            preorder, inorder, 
            preStart + 1, preStart + leftTreeSize, 
            inStart, r - 1);

        root.right = buildTreeHelper(
            preorder, inorder, 
            preStart + leftTreeSize + 1, preEnd, 
            r + 1, inEnd);

        return root;
    }
    
}