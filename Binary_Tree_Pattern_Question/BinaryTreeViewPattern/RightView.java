class Solution {
    public class pair{
        TreeNode curr;
        int level;
        public pair(TreeNode curr,int level){
            this.curr = curr;
            this.level = level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
        if(root==null){
             return ans;
        }
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            TreeNode curr = q.peek().curr;
            int level = q.peek().level;
            q.remove();
            hm.put(level,curr.val);
            if(curr.left!=null){
                q.add(new pair(curr.left,level+1));
            }
            if(curr.right!=null){
                q.add(new pair(curr.right,level+1));

            }
        }
       
        for(int i : hm.values()){
             ans.add(i);
        }
        return ans;
    }
}