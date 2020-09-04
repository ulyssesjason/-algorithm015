class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            results.add(current.val);
            current = current.right;
        }
        
        return results;
    }
}
