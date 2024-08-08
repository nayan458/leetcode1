class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length;
        int c = image[0].length;
        int s_color = image[sr][sc];

        if(s_color == color)
            return image;
        image[sr][sc] = color;
        // right
        if(sc < (c-1))
            if(image[sr][sc+1] == s_color)
                floodFill(image, sr, sc+1, color);
        // left
        if(sc > 0)
            if(image[sr][sc-1] == s_color)
                floodFill(image, sr, sc-1, color);
        // top
        if(sr < (r-1))
            if(image[sr+1][sc] == s_color)
                floodFill(image, sr+1, sc, color);
        // bottom
        if(sr > 0)
            if(image[sr-1][sc] == s_color)
                floodFill(image, sr-1, sc, color);

        return image;
    }
}