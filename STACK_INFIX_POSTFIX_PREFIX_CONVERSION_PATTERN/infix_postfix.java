class Solution {
    public static int incompare(char ch){
        if(ch=='*' || ch=='/'){
            return 2;
        }else if(ch=='^'){
            return 3;
        }else if(ch=='+' || ch=='-'){
            return 1; 
        }else{
            return -1;
        }
    }
    public static String infixToPostfix(String s) {
        int i = 0;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(i<n){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z' || ch>='A' && ch<='Z' || ch>='0' && ch<='9'){
                sb.append(ch);
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty() &&  st.peek()!='('){
                    sb.append(st.peek());
                    st.pop();
                }
                st.pop();
            }else {
                while(!st.isEmpty() && incompare(st.peek())>=incompare(ch)){
                    sb.append(st.peek());
                    st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        return sb.toString();
        
    }
}