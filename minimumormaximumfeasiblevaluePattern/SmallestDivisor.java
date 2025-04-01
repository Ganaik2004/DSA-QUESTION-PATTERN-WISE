class Solution {
    public boolean util(int nums[],int threshold,int mid){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            count += Math.ceil((double)nums[i]/(double)mid);
        }
        return count<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int i = 0;i<nums.length;i++){
            high = Math.max(high,nums[i]);
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(util(nums,threshold,mid)){
              ans = mid;
              high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}