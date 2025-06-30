class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void pathSumII(TreeNode root, int targetSum, List<Integer> arr){
        // If null node
        if(root == null)
            return;

        arr.add(root.val);
        // If leaf node
        if((root.left == root.right) && (root.val == targetSum))
                ans.add(new ArrayList<>(arr));
        else {
            // usual case
            pathSumII(root.left, targetSum - root.val, arr);
            pathSumII(root.right, targetSum - root.val, arr);
        }

        arr.remove(arr.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSumII(root,targetSum, new ArrayList<>());
        return ans;
    }
}