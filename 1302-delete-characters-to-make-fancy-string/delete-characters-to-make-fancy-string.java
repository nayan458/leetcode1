class Solution {
    public String makeFancyString(String s) {
        StringBuffer str = new StringBuffer(s);
        int i = 1;
        char currCh = str.charAt(0);
        int count = 1;
        while(i < str.length()){
            char ch = str.charAt(i);
            if(currCh == ch){
                if(count == 2)
                    str.deleteCharAt(i);
                else{
                    count++;
                    i++;
                }
            } else{
                currCh = ch;
                count = 1;
                i++;
            }
        }
        return str.toString();
    }
}