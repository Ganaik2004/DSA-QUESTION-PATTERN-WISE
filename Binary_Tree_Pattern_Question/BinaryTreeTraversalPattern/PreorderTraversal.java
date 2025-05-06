class Solution {
    public void util(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        list.add(root.val);
        util(root.left,list);
        util(root.right,list);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        util(root,list);
        return list;
    }
}