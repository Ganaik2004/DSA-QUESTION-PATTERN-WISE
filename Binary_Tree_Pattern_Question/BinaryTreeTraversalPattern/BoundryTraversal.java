class Solution {
    boolean isLeaf(Node node){
        return node.left==null && node.right==null;
    }
    void addLeft(Node node,ArrayList<Integer> arr){
        Node curr = node.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                arr.add(curr.data);
            }
            if(curr.left==null){
                curr = curr.right;
            }else{
                 curr = curr.left;
            }
        }
    }
    void addLeaf(Node node,ArrayList<Integer> arr){
        if(node==null){
            return;
        }
        if(isLeaf(node)){
            arr.add(node.data);
            return;
        }
       
            addLeaf(node.left,arr);
        
        
            addLeaf(node.right,arr);
      
    }
    void addRight(Node node,ArrayList<Integer> arr){
        Node curr = node.right;
        ArrayList<Integer> list = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                list.add(curr.data);
               
            }
            if(curr.right==null){
                curr = curr.left;
            }else{
                 curr = curr.right;
            }
        }
        for(int i = list.size()-1;i>=0;i--){
            arr.add(list.get(i));
        }
        
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(node==null){
            return arr;
        }
        if(!isLeaf(node)){
            arr.add(node.data);
        }
        addLeft(node,arr);
        addLeaf(node,arr);
        addRight(node,arr);
        return arr;
    }
}