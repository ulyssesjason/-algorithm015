class Solution {
    public int minMutation(String start, String end, String[] bank) {

        if(bank.length == 0){
            return -1;
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                String node = queue.poll();
                if(node.equals(end)){
                    return count ;
                }
                for(int j = 0 ; j < bank.length ; j++){
                    String b = bank[j];
                    if(!visited.contains(b) && distance(node, b)){
                        queue.offer(b);
                        visited.add(b);
                    }
                }

            }
            count ++;
        }
        
        return -1;
    }
    
    private boolean distance(String s1, String s2){
        int count = 0;
        for(int i = 0 ; i < 8 ; i++){
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
