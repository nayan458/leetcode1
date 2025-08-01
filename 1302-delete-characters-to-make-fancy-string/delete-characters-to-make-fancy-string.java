class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        result.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                result.append(curr);
            }
        }

        return result.toString();
    }
}
