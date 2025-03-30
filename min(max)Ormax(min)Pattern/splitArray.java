class Solution {
    public int util(int nums[],int mid){
        int count = 1;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
                sum = sum+nums[i];
            }else{
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int i = 0;i<nums.length;i++){
             low = Math.max(low,nums[i]);
            high += nums[i];
        }
        int min = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            int h = util(nums,mid);
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