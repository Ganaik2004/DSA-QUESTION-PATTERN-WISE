class Solution {
    public class pair{
        TreeNode curr;
        int num;
        public pair(TreeNode curr,int num){
            this.curr = curr;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return  0;
        }
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        int ans = 0;
        while(!q.isEmpty()){
            int start = 0;
            int last = 0;
            int size = q.size();
            int mini = q.peek().num;
            for(int i = 0;i<size;i++){
                TreeNode curr = q.peek().curr;
                int num = q.peek().num-mini;
                q.remove();
                if(i==0) start = num;
                if(i==size-1) last = num;
                if(curr.left!=null){
                    q.add(new pair(curr.left,num*2+1));
                }
                if(curr.right!=null){
                    q.add(new pair(curr.right,num*2+2));
                }
               ans = Math.max(ans,last-start+1);

            }
        }
        return ans;

    }
}