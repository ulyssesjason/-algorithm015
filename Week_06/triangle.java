class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        List<List<Integer>> states = new ArrayList<>();        
        
        for(int i = 0 ; i < triangle.size() ; i++){
            states.add(new ArrayList<>(triangle.get(i)));
        }
        
        for(int i = 1 ; i < states.size() ; i++){
            for(int j = 0 ; j < states.get(i).size() ; j++){
                int min = Integer.MAX_VALUE;
                int left = j - 1;
                int right = j;
                if(left >= 0){
                    min = Math.min(min, states.get(i-1).get(left));
                }
                if(right < states.get(i-1).size()){
                    min = Math.min(min, states.get(i-1).get(right));
                }
                states.get(i).set(j, min + triangle.get(i).get(j));
            }
        }
        
        int ret = Integer.MAX_VALUE;
        
        for(int i : states.get(states.size() - 1)){
            ret = Math.min(ret, i);
        }
        return ret;
    }
}
