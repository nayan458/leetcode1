class Solution {
    private boolean[] lower = new boolean[26];
    private boolean[] upper = new boolean[26];

    public int numberOfSpecialChars(String word) {
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if('a' <= ch && ch <= 'z')
                lower[(int)(ch - 'a')] = true;
            else
                upper[(int)(ch - 'A')] = true;
        }

        int count = 0;
        for(int i = 0; i < 26; i++)
            count += (lower[i] && upper[i]) ? 1 : 0;

        return count;
    }
}