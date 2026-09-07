class Solution {

    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while(set.contains(ch)) {
                set.remove(s.charAt(j++));
            }
            set.add(ch);
            length = Math.max(length, set.size());
        }

        return Math.max(length,set.size());
    }
}
