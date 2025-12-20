class Solution {
    private static final char initialCh = (char)(((int)'a') - 1);
    static {
        String[] strs = {"abc", "bce", "cae"};
        for(int i = 0; i < 500; i++)
            minDeletionSize(strs);
    }
    public static int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i = 0; i < strs[0].length(); i++){
            char ch = initialCh;
            for(String str: strs){
                if(str.charAt(i) < ch) {  
                    count++;
                    break;
                }
                ch = str.charAt(i);
            }
       }
       return count;
    }
}