public class Codec {
    private Queue<TreeNode> q;

    public String serialize(TreeNode root) {
        return levelOrder(root);
    }

    public TreeNode deserialize(String data) {
        q = new LinkedList<>();
        String lvlOrder[] = data.split(",");

        if(data.equals(""))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(lvlOrder[0])), temp = null;
        q.add(root);
        for(int i = 1; i < lvlOrder.length - 1;){
            temp = q.poll();
            temp.left = insertNode(lvlOrder[i]);
            temp.right = insertNode(lvlOrder[i+1]);
            i += 2;
        }
        return root;
    }

    private TreeNode insertNode(String data){
        if(data.equals("n"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(data));
        q.add(node);
        return node;
    }

    private String levelOrder(TreeNode root) {
        q = new LinkedList<>();
        StringBuffer lvlorder = new StringBuffer();
        TreeNode temp = null;
        if(root == null)
            return lvlorder.toString();
        q.add(root);

        while(!q.isEmpty()){
            temp = q.poll();
            if(temp == null)
                lvlorder.append("n,");
            else{
                lvlorder.append(temp.val).append(",");
                q.add(temp.left);
                q.add(temp.right);
            }
        }

        return lvlorder.toString();
    }

}
// public class Codec {
//     // Encodes a tree to a single string.
//     private StringBuffer pre = new StringBuffer();
//     private StringBuffer in = new StringBuffer();

//     public String serialize(TreeNode root) {
//         preorder(root);
//         inorder(root);
//         pre.append(in);
//         return pre.toString();
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         // 
//         in.append(data);      
//         pre.append(in.subSequence(0,(in.length()/2)));
//         in.delete(0,(in.length()/2));

//         // to strings
//         String pre[] = parseToken(pre.toString());
//         String in[] = parseToken(in.toString());

//         return toTree();
//     }

//     private TreeNode toTree() {

//     }
    
//     private parseToken(String data){
//         return data.split(",");
//     }

//     private void preorder(TreeNode root){
//         if(root == null)
//             return;
//         pre.append(root.val).append("#").append(root.hashCode()).append(",");
//         preorder(root.left);
//         preorder(root.right);
//     }
//     private void inorder(TreeNode root){
//         if(root == null)
//             return;
//         inorder(root.left);
//         in.append(root.val).append("#").append(root.hashCode()).append(",");
//         inorder(root.right);
//     }
// }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));