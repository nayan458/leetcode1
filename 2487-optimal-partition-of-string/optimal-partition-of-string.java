class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                count++;
                set = new HashSet<>();
                set.add(s.charAt(i));
            }   else {
                set.add(s.charAt(i));
            }
        }

        if(set.size() > 0)
            return count+1;
        return count;
    }
}