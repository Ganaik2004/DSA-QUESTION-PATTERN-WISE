class Solution {
    public class pair{
        int row;
        int col;
        int step;
        public pair(int row,int col,int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j] = true;
                }
                if(grid[i][j]==1){
                    c++;
                }
            }
        }
        int max = 0;
        int count = 0;
        int nrow[] = {-1,0,+1,0};
        int ncol[] = {0,+1,0,-1};
        while(!q.isEmpty()){
             int row = q.peek().row;
             int col = q.peek().col;
             int step = q.peek().step;
             max = Math.max(max,step);
             q.remove();
             for(int i = 0;i<4;i++){
                int r = row+nrow[i];
                int cl = col+ncol[i];
                if(r>=0 && r<n && cl>=0 && cl<m && !vis[r][cl] && grid[r][cl]==1){
                    q.add(new pair(r,cl,step+1));
                    vis[r][cl] = true;
                    count++;
                }
             }

        }
        if(count!=c){
            return -1;
        }else{
            return max;
        }

    }
}