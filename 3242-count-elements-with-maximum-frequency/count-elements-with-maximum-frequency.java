class Solution {
    private final int[] freq = new int[101];
    public int maxFrequencyElements(int[] nums) {
        int max_freq = 0;
        for(int elem: nums){
            freq[elem]++;
            max_freq = Math.max(max_freq, freq[elem]);
        }
        int ans = 0;

        for(int elem: freq)
            if(elem == max_freq)
                ans++;
                
        return ans*max_freq;
    }
}