class Solution {
    
    class Count{
        int value;
        int count;
        public Count(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }
        
        PriorityQueue<Count> queue = new PriorityQueue<>(k, 
                                                         (c1, c2) -> Integer.compare(c1.count, c2.count));
        
        for(int i : map.keySet()){
            Count top = queue.peek();
            if(queue.size() < k || map.get(i) > top.count){
                queue.offer(new Count(i, map.get(i)));
            }
            if(queue.size() > k){
                queue.poll();
            }
        }
        
        int[] results = new int[k];
        
        for(int i = 0 ; i < k; i++){
            Count count = queue.poll();
            results[k - 1 - i] = count.value;
        }
        return results;
    }
}
