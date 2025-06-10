class Solution {
    public int maxDifference(String s) {
        
        Map<Character, Integer> hm = new HashMap<>();

        int maxOdd = Integer.MIN_VALUE + 1, maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE, minEven = Integer.MAX_VALUE - 1;
        
        for(int i = 0; i < s.length(); i++)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0) + 1);
        
        for (Map.Entry<Character,Integer> mapElement : hm.entrySet()) {
            int v = mapElement.getValue();
            if(v % 2 == 0) {
                if(maxEven < v)
                    maxEven = v;
                if(minEven > v)
                    minEven = v;
            } else {
                if(maxOdd < v)
                    maxOdd = v;
                if(minOdd > v)
                    minOdd = v;
            }
        }
        
        maxOdd -= minEven;
        minOdd -= maxEven;

        return maxOdd > minOdd ? maxOdd : minOdd;
    }
}