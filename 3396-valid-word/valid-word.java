class Solution {
    private static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));
    private boolean hasVowel = false;
    private boolean hasConsonant = false;

    public boolean isValid(String word) {
        if(word.length() < 3)
            return false;


        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch >= '0' && ch <= '9')
                continue;
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                if(vowels.contains(ch)){
                    this.hasVowel = true;
                    continue;
                }
                this.hasConsonant = true;
                continue;
            }
            return false;
        }

        return this.hasConsonant && this.hasVowel;
    }
}