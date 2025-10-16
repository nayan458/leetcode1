class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int elem : nums) {
            int mod = ((elem % value) + value) % value; // normalize negative mods
            hm.put(mod, hm.getOrDefault(mod, 0) + 1);
        }

        int i = 0;
        while (true) {
            int mod = i % value;
            if (hm.getOrDefault(mod, 0) > 0) {
                hm.put(mod, hm.get(mod) - 1);
                i++;
            } else {
                return i;
            }
        }
    }
}
