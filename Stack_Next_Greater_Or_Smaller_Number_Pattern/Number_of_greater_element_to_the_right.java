class Solution {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
      
      for(int i = 0;i<queries;i++){
          int count = 0;
          for(int j = indices[i]+1;j<arr.length;j++){
              if(arr[j]>arr[indices[i]]){
                  count++;
              }
          }
          indices[i] = count;
          
      }
      return indices;
       
    }
  }