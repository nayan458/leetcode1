import java.util.*;

class Solution {
    public int romanToInt(String s) {
        // Map of Roman numerals to their values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int currVal = roman.get(s.charAt(i));
            
            // If the current value is less than the next one, subtract it
            if (i + 1 < s.length() && currVal < roman.get(s.charAt(i + 1))) {
                total -= currVal;
            } else {
                total += currVal;
            }
        }

        return total;
    }
}
