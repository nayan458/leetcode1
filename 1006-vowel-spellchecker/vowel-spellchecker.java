class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] spell = new String[queries.length];
        Map<String,Set<String>> hm = new HashMap<>();

        for(String word: wordlist){
            String key = maskVowels(word.toLowerCase());
            hm.computeIfAbsent(key, k -> new LinkedHashSet<>()).add(word);
        }

        int i = 0;
        boolean flag = false;
        for(String querie: queries){
            flag = false;
            String maskQ = maskVowels(querie.toLowerCase());
            if(hm.containsKey(maskQ)){
                Set<String> candidate = hm.get(maskQ);
                if(candidate.contains(querie)) // exact match
                    spell[i++] = querie;
                else {
                    for(String s: candidate){
                        if(s.equalsIgnoreCase(querie)){
                            spell[i++] = s;
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        spell[i++] = candidate.iterator().next();
                    }
                }
            } else{
                spell[i++] = "";
            }
        }

        return spell;
    }
    private String maskVowels(String key) {
        return key.replaceAll("[AEIOUaeiou]", "*");
    }
}