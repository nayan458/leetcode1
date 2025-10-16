class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> hm = new HashMap<>();

        for(int elem: nums){
            int mod = ((elem % value) + value) % value;
            hm.put(mod, hm.getOrDefault(mod,0) + 1);
        }

        System.out.println(hm);

        int i = 0;

        for(i = 0; i < 100_001; i++) {
            if(hm.getOrDefault(i%value,0) > 0){
                hm.put(i%value, hm.get(i % value) - 1);
                continue;
            }
            else
                return i;
        }
        return i;
    }
}