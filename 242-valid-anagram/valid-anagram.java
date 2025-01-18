class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> frequencyCount = new HashMap<>();
        int n = s.length(), m = t.length();
        if(n != m)
            return false;
        for(int i = 0; i < n; i++)
            frequencyCount.put(s.charAt(i),frequencyCount.getOrDefault(s.charAt(i),0)+1);
        int count = 0;
        for(int i = 0; i < m; i++) {
            count = frequencyCount.getOrDefault(t.charAt(i),0);
            frequencyCount.put(t.charAt(i),--count);
            if(count < 0)
                return false;
        }
        return true;
    }
}