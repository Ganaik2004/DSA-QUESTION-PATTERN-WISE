class Solution {
    public static int util(int arr[],int mid){
        int count = 1;
        int last = 0;
        for(int i = 0;i<arr.length;i++){
            if(last+arr[i]<=mid){
                last +=arr[i];
            }else{
                count++;
                last = arr[i];
            }
        }
        return count;
    }
    public static int findPages(int[] arr, int k) {
        if(arr.length<k) return -1;
        
       
        int sum = 0;
        int low = Integer.MIN_VALUE;
        
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            low = Math.max(low,arr[i]);
        }
        int high = sum;
        int min  = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
           int h =  util(arr,mid);
            if(h<=k){
                min = Math.min(min,mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        return min;
    }
}