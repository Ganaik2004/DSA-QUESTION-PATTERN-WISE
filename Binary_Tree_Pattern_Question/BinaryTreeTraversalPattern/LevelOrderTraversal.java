class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> list = new ArrayList<>();
        if(root==null){return list;}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new LinkedList<>();
            for(int i = 0;i<size;i++){
              TreeNode curr = q.remove();
              ans.add(curr.val);
              if(curr.left!=null){
                q.add(curr.left);
              }
              if(curr.right!=null){
                q.add(curr.right);
              }
            }
            list.add(ans);
        }
        return list;
    }
}