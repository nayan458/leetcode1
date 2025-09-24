public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);
        num %= den;
        if (num == 0) return result.toString();

        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();
        while (num != 0) {
            if (remainderMap.containsKey(num)) {
                result.insert(remainderMap.get(num), "(");
                result.append(")");
                break;
            }
            remainderMap.put(num, result.length());
            num *= 10;
            result.append(num / den);
            num %= den;
        }
        return result.toString();
    }
}
