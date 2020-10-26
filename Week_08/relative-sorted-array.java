class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < arr2.length ; i++){
            map.put(arr2[i], i);
        }
        
        for(int i = 0 ; i < arr1.length - 1 ; i++){
            for(int j = i ; j < arr1.length ; j++){
               int w1 = map.containsKey(arr1[i]) ? map.get(arr1[i]) : arr2.length + arr1[i];
               int w2 = map.containsKey(arr1[j]) ? map.get(arr1[j]) : arr2.length + arr1[j];
               if(w1 > w2){
                   swap(arr1, i, j);
               }
            }
        }
        
        return arr1;
    }
    
    private void swap(int[] array, int from, int to){
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
