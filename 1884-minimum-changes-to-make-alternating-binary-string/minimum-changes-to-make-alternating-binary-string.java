class Solution {
    public int minOperations(String s) {
        char x = s.charAt(0);
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != x)
                count++;
            x = (x == '1' ? '0' : '1');
        }
        return Math.min(count,s.length() - count);
    }
}