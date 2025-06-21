class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        
        Set<Character> seen = new HashSet<>();
        int start = 0;

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            // If character already in window, shrink from left
            while (seen.contains(c)) {
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(c);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}