class Solution {
    public class pair{
        String first;
        int secound;
        public pair(String first,int secound){
            this.first = first;
            this.secound = secound;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Queue<pair> q = new LinkedList<>();
       HashSet<String> hs = new HashSet<>();
       for(int i = 0;i<wordList.size();i++){
        hs.add(wordList.get(i));
       } 
       q.add(new pair(beginWord,1));
    //    int count = 0;
       while(!q.isEmpty()){
        String first = q.peek().first;
        int secound = q.peek().secound;
        q.remove();
        if(first.equals(endWord)){
            return secound;
        }
        for(int i = 0;i<first.length();i++){
            for(char ch = 'a' ;ch<='z';ch++){
                char cha[] = first.toCharArray();
                cha[i] = ch;
                String ans = new String(cha);
            if(hs.contains(ans)){
                    hs.remove(ans);
                    q.add(new pair(ans,secound+1));

                }
            }
        }
       }
       return 0;
    }
}