class Solution {
    public void util(int grid[][],boolean vis[][],int nrow[],int ncol[],int sr,int sc){
        vis[sr][sc] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<4;i++){
            int r = sr+nrow[i];
            int c = sc+ncol[i];
            if(r>=0 && r<n && c>=0 && c<m &&!vis[r][c] && grid[r][c]==1){
                util(grid,vis,nrow,ncol,r,c);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int nrow[] = {-1,0,1,0};
        int ncol[] = {0,1,0,-1};
      boolean vis[][] = new boolean[n][m];
      for(int i = 0;i<n;i++){
        if(!vis[i][0] && grid[i][0]==1){
            util(grid,vis,nrow,ncol,i,0);
        }
        if(!vis[i][m-1] && grid[i][m-1]==1){
            util(grid,vis,nrow,ncol,i,m-1);
        }
      }

      for(int i = 0;i<m;i++){
        if(!vis[0][i] && grid[0][i]==1){
            util(grid,vis,nrow,ncol,0,i);
        }
        if(!vis[n-1][i] && grid[n-1][i]==1){
            util(grid,vis,nrow,ncol,n-1,i);
        }
      }
      int count = 0;
      for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(!vis[i][j] && grid[i][j]==1){
                count++;
            }
        }
      }
      return count;
    }
}