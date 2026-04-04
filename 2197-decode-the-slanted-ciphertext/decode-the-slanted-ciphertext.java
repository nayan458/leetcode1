class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder str = new StringBuilder();
        int cols = (int)Math.ceil(encodedText.length()/rows);
        for(int i = 0; i < cols; i++){
            int idx = i;
            while(idx < encodedText.length()){
                str.append(encodedText.charAt(idx));
                idx += cols+1;
            }
        }
        return str.toString().stripTrailing();
    }
}