class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') {
                if(flag)
                    return false;
                while(i < s.length() && s.charAt(i) == '1') i++; 
                flag = true;
            } 
        }
        return true;
    }
}