class Solution {
    private static final StringBuilder INITIAL_STRING =
        new StringBuilder(String.valueOf((char) ('a' - 1)));

    public int minDeletionSize(String[] strs) {
        int size = strs[0].length();
        int n = strs.length;
        int count = 0;

        StringBuilder[] sb = new StringBuilder[n];
        for(int i = 0; i < n; i++)
            sb[i] = new StringBuilder();

        boolean deleteCol = false;
        boolean skipCol = false;

        for(int i = 0; i < size; i++){
            StringBuilder prev = INITIAL_STRING;
            for(int j = 0; j < n; j++){
                char ch = strs[j].charAt(i);
                sb[j] = sb[j].append(ch);
                if(prev.toString().compareTo(sb[j].toString()) > 0){
                    count++;
                    deleteCol(sb,j);
                    deleteCol = true;
                    skipCol = false;
                    break;
                }
                if(prev.toString().compareTo(sb[j].toString()) == 0)
                    skipCol = true;
                prev = sb[j];
            }
            if(!deleteCol && !skipCol) 
                return count;
        }

        return count;
    }

    private void deleteCol(StringBuilder[] sb, int until) {
        for(int i = 0; i <= until; i++){
            sb[i].deleteCharAt(sb[i].length() - 1);
        }
    }
}