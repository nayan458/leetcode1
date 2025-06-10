class Solution {

    private Set<Character> vowel = Set.of('a','e','i','o','u');

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++ ) {
            if (vowel.contains(words[i].charAt(0)) && vowel.contains(words[i].charAt((words[i].length() - 1))))
                count++;
        }

        return count;
    }
}