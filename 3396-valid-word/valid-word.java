class Solution {
    private Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));

    public boolean isValid(String word) {
        boolean hasVowel = false;
        boolean hasConsonant = false;
        if(word.length() < 3)
            return false;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch >= '0' && ch <= '9')
                continue;
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                if(!hasVowel && vowels.contains(ch)){
                    hasVowel = true;
                    continue;
                }
                if(!hasConsonant && !vowels.contains(ch)){
                    hasConsonant = true;
                    continue;
                }
                continue;
            }
            return false;
        }

        return hasConsonant && hasVowel;
    }
}