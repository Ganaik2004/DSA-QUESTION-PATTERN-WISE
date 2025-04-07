class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length-1;i>=0;i--){
            int curr = nums2[i];
            while(!st.isEmpty() && st.peek()<=curr){
                st.pop();
            }
            hm.put(curr,st.isEmpty()?-1:st.peek());
            st.push(curr);
        }
        for(int i = 0;i<nums1.length;i++){
            nums1[i] = hm.get(nums1[i]);
        }
        return nums1;
    }
}