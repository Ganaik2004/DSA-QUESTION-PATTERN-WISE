class Solution {
    int max = 0;
    int sum = 0;
    public void util(int[][] grid, boolean vis[][],int nrow[],int ncol[],int r,int c){
        vis[r][c] = true;
        sum+=grid[r][c];
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<4;i++){
            int row = r+nrow[i];
            int col = c+ncol[i];
            if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && grid[row][col]>0){
                util(grid,vis,nrow,ncol,row,col);
            }
        }
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int nrow[] = {-1,0,1,0};
        int ncol[] = {0,1,0,-1};
        boolean vis[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
           for(int j = 0;j<m;j++){
            if(!vis[i][j] && grid[i][j]>0){
                sum = 0;
            util(grid,vis,nrow,ncol,i,j);
            max  = Math.max(max,sum);
            }
            
           }
        }
        
       
        return max;
    }
}