class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<adj.size();i++){
            if(!vis[i]){
                q.add(i);
                vis[i] = true;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    arr.add(curr);
                    for(int j = 0;j<adj.get(curr).size();j++){
                        int nei = adj.get(curr).get(j);
                        if(!vis[nei]){
                            q.add(nei);
                            vis[nei] = true;
                        }
                    }
                }
            }
        }
        return arr;
        
    }
}