class Solution {
    private static Set<Character> vowel = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u')
    );

    public boolean doesAliceWin(String s) {
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(vowel.contains(ch)) 
                return true;
        }
        return false;
    }
}