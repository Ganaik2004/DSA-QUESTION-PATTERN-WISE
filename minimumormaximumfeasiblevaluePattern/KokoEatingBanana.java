class Solution {
    public boolean util(int piles[],int h,int k){
        int count = 0;
        for(int i = 0;i<piles.length;i++){
            count+=Math.ceil((double)piles[i]/(double)k);
            if(count>h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        int ans = 0;
        while(low<=high){
          int mid = (low+high)/2;
          if(util(piles,h,mid)){
            ans = mid;
            high = mid-1;
          }else{
            low = mid+1;
          }
        }
        return ans;

    }
}