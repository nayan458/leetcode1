class Solution {
    public int reverseDegree(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++)
            count += (26 - (int)(s.charAt(i) - 'a')) * (i+1);
            // System.out.println(26 - (int)(s.charAt(i) - 'a'));
        return count;
    }
}