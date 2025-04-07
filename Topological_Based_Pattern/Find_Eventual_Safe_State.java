class Solution {
    public void indeg(List<List<Integer>> adj, int indeg[]){
        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                int nei = adj.get(i).get(j);
                indeg[nei]++;
            }
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int indeg[] = new int[graph.length];
        for(int i = 0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<graph.length;i++){
            for(int j = 0;j<graph[i].length;j++){
                int nei = graph[i][j];
                adj.get(nei).add(i);
            }
        }
        indeg(adj,indeg);
        Queue<Integer> q = new LinkedList<>();
       
        for(int i = 0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int i = 0;i<adj.get(curr).size();i++){
                int nei = adj.get(curr).get(i);
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.add(nei);
                }
            }
        }
        Collections.sort(ans);
        return ans;

    }
}