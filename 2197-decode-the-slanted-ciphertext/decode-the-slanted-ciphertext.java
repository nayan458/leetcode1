class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int len = encodedText.length();
        int cols = (len + rows - 1) / rows;

        char[] result = new char[len];
        int pos = 0;

        for (int startCol = 0; startCol < cols; startCol++) {
            int r = 0, c = startCol;

            while (r < rows && c < cols) {
                int idx = r * cols + c;
                if (idx < len) {
                    result[pos++] = encodedText.charAt(idx);
                }
                r++;
                c++;
            }
        }

        // remove trailing spaces
        int end = pos - 1;
        while (end >= 0 && result[end] == ' ') end--;

        return new String(result, 0, end + 1);
    }
}