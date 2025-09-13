class Solution {
    private static Set<Character> vowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u')
    );

    public int maxFreqSum(String s) {
        int vowel = 0, consonent = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0) + 1);
            if(vowels.contains(ch)){
                vowel = Math.max(vowel, hm.get(ch));
            } else{
                consonent = Math.max(consonent, hm.get(ch));
            }
        }

        return vowel + consonent;
        
    }
}