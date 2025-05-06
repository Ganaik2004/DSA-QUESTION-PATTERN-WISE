class Solution {
    public class Tuple{
        TreeNode node;
        int dis;
        int level;
        public Tuple(TreeNode node,int dis,int level){
             this.node = node;
             this.dis = dis;
             this.level = level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> hm = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            TreeNode curr = q.peek().node;
            int dis = q.peek().dis;
            int level = q.peek().level;
            q.remove();
            if(!hm.containsKey(dis)){
                hm.put(dis,new TreeMap<>());
            }
            if(!hm.get(dis).containsKey(level)){
                hm.get(dis).put(level,new PriorityQueue<>());
            }
            hm.get(dis).get(level).offer(curr.val);
            if(curr.left!=null){
                q.add(new Tuple(curr.left,dis-1,level+1));
            }
            if(curr.right!=null){
                q.add(new Tuple(curr.right,dis+1,level+1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> hs: hm.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : hs.values()){
                while(!pq.isEmpty()){
                    list.get(list.size()-1).add(pq.peek());
                    pq.remove();
                }
            }
        }
        return list;

    }
}