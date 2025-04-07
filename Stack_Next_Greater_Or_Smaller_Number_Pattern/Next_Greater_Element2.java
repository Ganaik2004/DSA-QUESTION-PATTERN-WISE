class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length-1;i>=0;i--){
            st.push(nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--){
            int curr = nums[i];
            if(!st.isEmpty()){
                while(!st.isEmpty() && st.peek()<=curr){
                    st.pop();
                }
                if(st.isEmpty()){
                    nums[i] = -1;
                }else{
                    nums[i] = st.peek();
                }
            }else{
                nums[i] = -1;
            }
            st.push(curr);
        }
        return nums;
    }
}