class Solution {
    public void util(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        util(root.left,list);
        util(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        util(root,list);
        return list;
    }
}