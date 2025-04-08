public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<A.length;i++){
            int curr = A[i];
            if(!st.isEmpty()){
                while(!st.isEmpty() && st.peek()>=curr){
                    st.pop();
                }
                if(st.isEmpty()){
                    A[i] = -1;
                }else{
                    A[i] = st.peek();
                }
            }else{
                A[i] = -1;
            }
            st.push(curr);
        }
        return A;
    }
}