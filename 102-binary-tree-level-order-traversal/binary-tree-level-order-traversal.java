// class Solution {
    
//     public List<List<Integer>> levelOrder(TreeNode root) {
        
//         if(root == null)
//             return new ArrayList<>();

//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> level = new ArrayList<>();
//         Queue<List<TreeNode>> q = new LinkedList<>();
//         List<TreeNode> a_level = new ArrayList<>();  // add
//         List<TreeNode> r_level = new ArrayList<>();  // remove

//         level.add(root.val);
//         ans.add(level);

//         a_level.add(root);
//         q.add(a_level);

//         while(!q.isEmpty()) {
//             level = new ArrayList<>();
//             a_level = new ArrayList<>();
//             r_level = q.remove();
//             for (TreeNode e : r_level) {
//                 if(e.left != null){
//                     a_level.add(e.left);
//                     level.add(e.left.val);
//                 }
//                 if(e.right != null){
//                     a_level.add(e.right);
//                     level.add(e.right.val);
//                 }
//             }
//             if(a_level.size() > 0)
//                 q.add(a_level);
//             if(level.size() > 0)
//                 ans.add(level);
//         }

//         return ans;        
//     }
// }

// OPTIMIZED VERSION

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();  // Number of nodes at current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            ans.add(level);
        }

        return ans;
    }
}
