class Solution {

    public String minWindow(String s, String t) {
        int s_length = s.length();
        int t_length = t.length();

        int size = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;

        Map<Character, Integer> reqFrequency = new HashMap<>(26);
        Map<Character, Integer> curFrequency = new HashMap<>(26);

        for(int i = 0; i < t_length; i++) {
            char ch = t.charAt(i);
            reqFrequency.put(ch, reqFrequency.getOrDefault(ch,0) + 1);
        }

        int right = 0, left = 0;
        while(right < s_length) {
            char ch = s.charAt(right);
            if(reqFrequency.containsKey(ch)) {
                curFrequency.put(ch, curFrequency.getOrDefault(ch,0)+1);
                if(curFrequency.get(ch) <=  reqFrequency.get(ch))
                    count++;
            }
            
            // check if we can srink the window
            char prevCh = s.charAt(left);
            while(!reqFrequency.containsKey(prevCh) || (curFrequency.get(prevCh) > reqFrequency.get(prevCh))) {
                if(left == right)
                    break;
                left++;
                if(curFrequency.containsKey(prevCh)) {
                    curFrequency.put(prevCh,curFrequency.get(prevCh) - 1);
                    if(curFrequency.get(ch) <  reqFrequency.get(ch))
                        count--;
                }
                prevCh = s.charAt(left);
            }
            

            // check if both the hm are equal

            if(count == t_length) {
                int currSize = right - left + 1;
                if(currSize < size) {
                    start = left;
                    size = currSize;
                }
            }
                
            right++;
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}