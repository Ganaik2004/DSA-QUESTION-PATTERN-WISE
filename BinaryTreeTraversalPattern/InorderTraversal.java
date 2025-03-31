class Solution {
    public void util(TreeNode root,List<Integer> arr){
        if(root==null){
            return ;
        }
       
        util(root.left,arr);
        arr.add(root.val);
        util(root.right,arr);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        util(root,list);
        return list;
    }
}