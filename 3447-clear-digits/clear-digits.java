class Solution {
    public String clearDigits(String s) {
        StringBuilder str = new StringBuilder("");
        int n = s.length(), i = 0;

        while(i < n) {
            if((int)s.charAt(i) < 97 )
                str.delete((str.length() - 1), str.length());
            else
                str.append(s.charAt(i));
            i++;
        }
        
        return str.toString();
    }
}