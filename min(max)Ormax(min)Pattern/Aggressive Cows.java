class Solution {
    public static boolean util(int stalls[],int mid,int k){
        int count = 1;
        int last = stalls[0];
        for(int i = 1;i<stalls.length;i++){
            if((stalls[i]-last)>=mid){
                last = stalls[i];
                count++;
            }
        }
        return count>=k;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1]-stalls[0];
        int max = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(util(stalls,mid,k)==true){
                low = mid+1;
                max = Math.max(-1,mid);
            }else{
                high = mid-1;
            }
        }
        return max;
    }
}