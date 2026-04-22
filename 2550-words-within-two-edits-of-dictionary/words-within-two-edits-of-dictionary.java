class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String target: queries) {
            for(String word: dictionary) {
                if(word.length() != target.length()) continue;
                int count = 0, i = 0;
                while(i < word.length()){
                    if(count > 2) break;
                    if(word.charAt(i) != target.charAt(i)) count++;
                    i++;
                }
                if(count < 3){
                    ans.add(target);
                    break;
                }
            }
        }
        return ans;
    }
}