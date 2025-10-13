class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        Map<Character, Integer> curr_hm = new HashMap<>();
        for(String word: words){
            Map<Character, Integer> hm = new HashMap<>();
            for(int i = 0; i < word.length(); i++)
                hm.put(word.charAt(i), hm.getOrDefault(word.charAt(i),0) + 1);
            if(hm.equals(curr_hm))
                continue;
            ans.add(word);
            curr_hm = hm;
        }
        return ans;
    }
}