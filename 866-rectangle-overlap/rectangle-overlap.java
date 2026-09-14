class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1], x2 = rec1[2], y2 = rec1[3];
        int x_1 = rec2[0], y_1 = rec2[1], x_2 = rec2[2], y_2 = rec2[3];

        return !(
            Math.max(x1, x2) <= Math.min(x_1, x_2) ||
            Math.max(x_1, x_2) <= Math.min(x1, x2) ||
            Math.max(y1, y2) <= Math.min(y_1, y_2) ||
            Math.max(y_1, y_2) <= Math.min(y1, y2)
        );
    }
}

// 4

// 3       *-------*
//         |       |
// 2   *-------*   |
//     |   |   |   |
// 1   |   *---|---*
// 0   *-------*
//     0   1   2   3   4