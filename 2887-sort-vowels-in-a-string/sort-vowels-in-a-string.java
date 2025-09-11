class Solution {
    static char[] vowel = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
    static Set<Character> vowels = new HashSet<>(
            Arrays.asList('A', 'E', 'I', 'O', 'U', 
                        'a', 'e', 'i', 'o', 'u')
        );
    public String sortVowels(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        List<Integer> index = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        

        for(int i = 0; i < s.length(); i++){
            if(!vowels.contains(s.charAt(i)))   continue;
            
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            index.add(i);
        }

        System.out.println(hm);

        int j = 0;
        char x = vowel[j];
        int f = hm.getOrDefault(x,0);

        for(int i = 0; i < index.size(); i++){
            while(f == 0){
                x = vowel[++j];
                f = hm.getOrDefault(x,0);
            }

            sb.setCharAt(index.get(i),x);
            f--;
        }

        return sb.toString();
    }
}