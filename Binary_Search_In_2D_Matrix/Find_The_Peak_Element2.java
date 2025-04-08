class Solution {
    public int max(int mat[][],int n,int m,int mid){
         int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (mat[i][mid] > max) {
                max = mat[i][mid];
                idx = i;
            }
        }
        return idx;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int idx = max(mat,n,m,mid);
            int left = mid-1>=0 ? mat[idx][mid-1] : -1;
            int right = mid+1<m ? mat[idx][mid+1] : -1;
            if(mat[idx][mid]>left && mat[idx][mid]>right){
                return new int[]{idx,mid};
            }else if(left>mat[idx][mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return new int[]{-1,-1};
        
    }
}