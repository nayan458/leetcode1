class Solution {
    private int[] isSpecial = new int[26];

    public int numberOfSpecialChars(String word) {
        int n = word.length(), count = 0;

        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            updateSpecial(ch);
        }

        for(int i = 0; i < 26; i++)
            count += (isSpecial[i] == 2 ? 1 : 0);

        return count;
    }

    private void updateSpecial(char ch) {
        int idx;

        if('a' <= ch && ch <= 'z') {
            idx = ch - 'a';
            if(isSpecial[idx] == 0) 
                isSpecial[idx] = 1;
            if(isSpecial[idx] == 2) 
                isSpecial[idx] = -1;
        }
        if('A' <= ch && ch <= 'Z') {
            idx = ch - 'A';
            if(isSpecial[idx] == 0) 
                isSpecial[idx] = -1;
            if(isSpecial[idx] == 1) 
                isSpecial[idx] = 2;
        }

    }
}