class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        int top = -1;
        for(int i = 0; i < s.length(); i++){
            if(top != -1 && s.charAt(i) == ans.charAt(top))
                ans.setLength(top--);
            else{
                ans.append(s.charAt(i));
                ++top;
            }
        }
        return ans.toString();
    }
}