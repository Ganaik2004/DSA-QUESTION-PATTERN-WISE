class Solution {
    public void util(char[][] board, boolean vis[][],int nrow[],int ncol[],int r,int c){
        vis[r][c] = true;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i<4;i++){
            int row = r+nrow[i];
            int col = c+ncol[i];
            if(row>=0 && row<n && col>=0 && col<m && !vis[row][col] && board[row][col]=='O'){
                util(board,vis,nrow,ncol,row,col);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int nrow[] = {-1,0,1,0};
        int ncol[] = {0,1,0,-1};
        boolean vis[][] = new boolean[n][m];
        for(int i = 0;i<n;i++){
            if(!vis[i][0] && board[i][0]=='O'){
                util(board,vis,nrow,ncol,i,0);
            }
            if(!vis[i][m-1] && board[i][m-1]=='O'){
                util(board,vis,nrow,ncol,i,m-1);
            }
        }
        for(int i = 0;i<m;i++){
            if(!vis[0][i]  && board[0][i]=='O'){
                util(board,vis,nrow,ncol,0,i);
            }
            if(!vis[n-1][i] && board[n-1][i]=='O'){
                util(board,vis,nrow,ncol,n-1,i);
            }
        }
       
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                      board[i][j] = 'X';
                }
            }
        }
       
    }
}