class Solution {
    public int minAddToMakeValid(String s) {
       int x = 0;
       int sum = 0;

       for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sum += ch == '(' ? 1 : -1;
            if(sum < 0)
                x++;
            if(sum < 0 && ch == ')')
                sum = 0;
       }    

       return x + Math.max(sum,0);
    }


}