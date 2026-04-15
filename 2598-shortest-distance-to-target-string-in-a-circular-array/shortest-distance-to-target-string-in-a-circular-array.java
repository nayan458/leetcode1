class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
            if(words[i].equals(target))
                ans = Math.min(ans,Math.min(Math.abs(startIndex - i), n - Math.abs(startIndex - i)));
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}