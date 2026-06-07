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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> hm = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int[] description: descriptions){
            int parent = description[0];
            int child = description[1];
            if(!hm.containsKey(parent))
                hm.put(parent, new TreeNode(parent));
            if(!hm.containsKey(child))
                hm.put(child, new TreeNode(child));
            if(description[2] == 1)
                hm.get(parent).left = hm.get(child);
            else
                hm.get(parent).right = hm.get(child);
            set.add(child);
        }

        int i = 0;
        TreeNode head = hm.get(descriptions[i][0]);

        while(set.contains(head.val) && i < descriptions.length) {
            head = hm.get(descriptions[i][0]);
            i++;
        }

        return head;
    }
}