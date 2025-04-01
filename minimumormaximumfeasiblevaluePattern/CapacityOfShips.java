class Solution {
    public int util(int weights[],int days,int mid){
        int count = 1;
        int sum = 0;
        for(int i = 0;i<weights.length;i++){
           sum+=weights[i];
           if(sum>mid){
            count++;
            sum = weights[i]; 
           }
        }
        return count;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int i = 0;i<weights.length;i++){
            high += weights[i];
            low  = Math.max(weights[i],low);
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            int k = util(weights,days,mid);
            if(k<=days){
             ans = mid;
             high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}