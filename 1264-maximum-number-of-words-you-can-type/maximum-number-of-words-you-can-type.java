class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        Set<Character> brokenLettersSet = new HashSet<>();
        int count = words.length;

        for(int i = 0; i < brokenLetters.length(); i++)
            brokenLettersSet.add(brokenLetters.charAt(i));

        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                if(brokenLettersSet.contains(word.charAt(i))){
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}