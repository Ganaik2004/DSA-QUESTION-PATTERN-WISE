class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0;i<n;i++){
            int count = 0;
            for(int j = 0;j<arr[i].length;j++){
                if(arr[i][j]==1){
                    count++;
                }
            }
           if(count>max){
               max = count;
               idx = i;
           }
            
        }
        return idx;
    }
}