class Solution {
    public class pair{
        Node curr;
        int level;
        public pair(Node curr,int level){
            this.curr = curr;
            this.level = level;
        }
    }
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
       TreeMap<Integer,Integer> hm = new TreeMap<>();
       Queue<pair> q = new LinkedList<>();
       q.add(new pair(root,0));
       while(!q.isEmpty()){
           Node curr = q.peek().curr;
           int level = q.peek().level;
           q.remove();
           if(!hm.containsKey(level)){
               hm.put(level,curr.data);
           }
           if(curr.left!=null){
               q.add(new pair(curr.left,level+1));
           }
           if(curr.right!=null){
               q.add(new pair(curr.right,level+1));
           }
       }
       
       for(int i : hm.values()){
           list.add(i);
       }
       return list;
    }
}