class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int len = encodedText.length();
        int cols = (int)Math.ceil((double) len / rows);

        StringBuilder str = new StringBuilder(len);

        for (int i = 0; i < cols; i++) {
            int idx = i;
            while (idx < len) {
                str.append(encodedText.charAt(idx));
                idx += cols + 1;
            }
        }

        return str.toString().stripTrailing();
    }
}