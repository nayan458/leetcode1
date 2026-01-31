class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char min = 'z' + 1;
        for(char ch: letters)
            if(ch > target && min > ch)
                min = ch;
        return min == 'z' + 1 ? letters[0] : min;
    }
}