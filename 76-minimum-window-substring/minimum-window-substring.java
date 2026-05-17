class Solution {
    private String ans = new String("");
    public String minWindow(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();

        Map<Character, Integer> reqFrequency = new HashMap<>(26);
        Map<Character, Integer> curFrequency = new HashMap<>(26);

        for(int i = 0; i < t_length; i++) {
            char ch = t.charAt(i);
            reqFrequency.put(ch, reqFrequency.getOrDefault(ch,0) + 1);
        }

        int right = 0, left = 0;
        while(right < s_length) {
            char ch = s.charAt(right);
            if(reqFrequency.containsKey(ch))
                curFrequency.put(ch, curFrequency.getOrDefault(ch,0)+1);
            
            // check if we can srink the window
            char prevCh = s.charAt(left);
            while(!reqFrequency.containsKey(prevCh) || (curFrequency.get(prevCh) > reqFrequency.get(prevCh))) {
                if(left == right)
                    break;
                left++;
                if(curFrequency.containsKey(prevCh))
                    curFrequency.put(prevCh,curFrequency.get(prevCh) - 1);
                prevCh = s.charAt(left);
            }
            

            // check if both the hm are equal
            int count = 0;
            for(char keyCh: curFrequency.keySet())
                count += Math.min(curFrequency.get(keyCh),reqFrequency.get(keyCh));
            if(count == t_length)
                minString(left,right,s);
            right++;
        }
        return ans;
    }

    void minString(int left, int right, String s) {
        if(ans.equals("") || ans.length() > (right - left + 1))
            ans = s.substring(left,right+1);
        return;
    }
}