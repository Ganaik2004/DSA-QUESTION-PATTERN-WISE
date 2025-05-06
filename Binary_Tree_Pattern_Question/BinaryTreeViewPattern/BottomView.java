class Solution
{
    public class pair{
        Node node;
        int dis;
        public pair(Node node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
       TreeMap<Integer,Integer> hm = new TreeMap<>();
       Queue<pair> q= new LinkedList<>();
       q.add(new pair(root,0));
       while(!q.isEmpty()){
           Node curr = q.peek().node;
           int dis = q.peek().dis;
           q.remove();
           hm.put(dis,curr.data);
           if(curr.left!=null){
               q.add(new pair(curr.left,dis-1));
           }
           if(curr.right!=null){
               q.add(new pair(curr.right,dis+1));
           }
       }
       ArrayList<Integer> arr = new ArrayList<>();
       for(int i : hm.values()){
           arr.add(i);
       }
       return arr;
    }
}