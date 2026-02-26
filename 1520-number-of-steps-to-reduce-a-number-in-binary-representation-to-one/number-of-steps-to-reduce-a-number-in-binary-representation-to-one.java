class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Traverse from right to left (ignore MSB)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 1) {
                // odd -> add 1 then divide
                steps += 2;
                carry = 1;
            } else {
                // even -> just divide
                steps += 1;
            }
        }

        return steps + carry;
    }
}