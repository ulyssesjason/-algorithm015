class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] states = new int[amount+1];
        for(int i = 0 ; i < amount+1 ; i++){
            states[i] = Integer.MAX_VALUE;
        }
        
        for(int c : coins){
            if(c <= amount){
                states[c] = 1;
            }
        }
        for(int i = 1 ; i < amount + 1; i++){
            if(states[i] != Integer.MAX_VALUE){
                continue;
            }
            for(int c : coins){
                if(i - c > 0 && states[i-c] != Integer.MAX_VALUE){
                    states[i] = Math.min(states[i], states[i-c]+1);
                }
            }   
        }
        return states[amount] == Integer.MAX_VALUE ? -1 : states[amount];
    }
}
