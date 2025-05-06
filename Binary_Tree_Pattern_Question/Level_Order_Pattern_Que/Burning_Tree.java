class Solution {
    /*class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    public static void parent_mark(HashMap<Node,Node> hm,Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr.left!=null){
                q.add(curr.left);
                hm.put(curr.left,curr);
            }
            if(curr.right!=null){
               q.add(curr.right);
               hm.put(curr.right,curr);
            }
        }
    }
    public static Node find(Node root,int target){
        if(root==null){
            return null;
        }
        if(root.data==target){
            return root;
        }
       Node left =  find(root.left,target);
       Node right =  find(root.right,target);
       if(left!=null){
           return left;
       }else{
           return right;
       }
        
    }
    public static int minTime(Node root, int target) {
        HashMap<Node,Node> hm = new HashMap<>();
        HashMap<Node,Boolean> vis = new HashMap<>();
        parent_mark(hm,root);
        Queue<Node> q = new LinkedList<>();
        Node tar = find(root,target);
        if(tar==null){
            return 0;
        }
        q.add(tar);
        vis.put(tar,true);
        int ans = 0;
        while(!q.isEmpty()){
            int size  = q.size();
            ans++;
            for(int i = 0;i<size;i++){
                Node curr = q.remove();
                if(curr.left!=null && vis.get(curr.left)==null){
                    q.add(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    q.add(curr.right);
                    vis.put(curr.right,true);
                }
                if(hm.get(curr)!=null && vis.get(hm.get(curr))==null){
                    q.add(hm.get(curr));
                    vis.put(hm.get(curr),true);
                }
            }
        }
        return ans-1;
        
    }
}