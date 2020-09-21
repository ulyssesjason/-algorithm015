class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        if(wordList.size() == 0){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                String node = queue.poll();
                if(node.equals(endWord)){
                    return count + 1;
                }
                for(String s : wordList){
                    if(!visited.contains(s) && valid(node, s)){
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
            count ++;
        }
        
        
        return 0;
    }
    
    private boolean valid(String s1, String s2){
        int count = 0;
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count ++;
            }
            if(count > 1){
                return false;
            }
        }
        return count == 1;
    }
}
