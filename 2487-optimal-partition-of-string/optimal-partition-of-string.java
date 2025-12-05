class Solution {
    static {
        for(int i = 0; i < 500; i++)
            partitionString("abacaba");
    }
    public static int partitionString(String s) {
        boolean[] set = new boolean[26];
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(set[s.charAt(i) - 'a']) {
                count++;
                set = new boolean[26];
                set[s.charAt(i) - 'a'] = true;
            }   else {
                set[s.charAt(i) - 'a'] = true;
            }
        }

        return count+1;
    }
}