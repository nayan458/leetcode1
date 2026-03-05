class Solution {
    public int minOperations(String s) {
        char x = '1';
        int count = 0;
        int count1 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != x)
                count++;
            x = (x == '1' ? '0' : '1');
        }
        x = '0';
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != x)
                count1++;
            x = (x == '1' ? '0' : '1');
        }
        return Math.min(count,count1);
    }
}