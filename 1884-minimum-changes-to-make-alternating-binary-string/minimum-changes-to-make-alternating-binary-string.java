class Solution {
    public int minOperations(String s) {
        char x = '1';
        char y = '0';
        char temp = ' ';
        int count = 0;
        int count1 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != x)
                count++;
            else
                count1++;
            temp = x;
            x = y;
            y = temp;
        }
        return Math.min(count,count1);
    }
}