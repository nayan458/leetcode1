class Solution {
    private int LuckyNumber = -1;
    public int findLucky(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++)
            hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);
        
        for (Map.Entry<Integer,Integer> mapElement : hm.entrySet()){
            if(mapElement.getKey() == mapElement.getValue())
                LuckyNumber = Math.max(LuckyNumber, mapElement.getKey());
        }

        return LuckyNumber;
    }
}