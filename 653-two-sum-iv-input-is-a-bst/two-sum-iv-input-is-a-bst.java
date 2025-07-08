// Approach II: solve using Tree iterator
class Solution {

    public boolean findTarget(TreeNode root, int k) {
        BSTI obj1 = new BSTI(root, true);
        BSTI obj2 = new BSTI(root, false);

        TreeNode left = obj1.next();
        TreeNode right = obj2.next();

        while(left != null && right != null && left != right){
            int target = left.val + right.val;
            if( target == k)
                return true;
            if( target > k)
                right = obj2.next();
            else
                left = obj1.next();
        }

        return false;
    }
}

class BSTI{
    private Stack<TreeNode> st = new Stack<>();
    private boolean asc;
    public BSTI(TreeNode root, boolean asc){
        this.asc = asc;
        if(asc)
            asc(root);
        else
            desc(root);
    }

    public TreeNode next(){
        if(hasNext()){
            TreeNode node = st.pop();
            if(asc)
                asc(node.right);
            else
                desc(node.left);
            return node;
        }
        return null;
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    public void asc(TreeNode root){
        if(root == null)    return;
        st.push(root);
        asc(root.left);
    }

    public void desc(TreeNode root){
        if(root == null)    return;
        st.push(root);
        desc(root.right);
    }
}

// Approach I: Solve by converting into an Array
// class Solution {
//     private List<Integer> arr = new ArrayList<>();

//     public boolean findTarget(TreeNode root, int k) {
//         if(root == null && root.right == root.left)
//             return false;

//         inorder(root);

//         int right = arr.size() - 1, left = 0;
//         while(left < right){
//             int target = (arr.get(left) + arr.get(right));
//             if( target == k)
//                 return true;
//             if( target > k)
//                 right--;
//             else
//                 left++;
//         }

//         return false;
//     }

//     private void inorder(TreeNode root){
//         if(root == null)
//             return;
//         inorder(root.left);
//         arr.add(root.val);
//         inorder(root.right);
//     }
// }