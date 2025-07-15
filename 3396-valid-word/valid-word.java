class Solution {
    private static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));

    public boolean isValid(String word) {
        if(word.length() < 3)
            return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch >= '0' && ch <= '9')
                continue;
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                if(vowels.contains(ch)){
                    hasVowel = true;
                    continue;
                }
                hasConsonant = true;
                continue;
            }
            return false;
        }

        return hasConsonant && hasVowel;
    }
}