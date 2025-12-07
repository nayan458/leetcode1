class Solution {
    public int countOdds(int low, int high) {
        int upperBound = high % 2 != 0 ? (high + 1) : high;
        int lowerBound = low % 2 != 0 ? (low - 1) : low;
        return (upperBound - lowerBound)/2;
    }
}

// 3 4 5 6 7   = 3-1 = 2
// 3 4 5 6 7 8 = 4 - 1 = 2
// 2 3 4 5 6 7 = 3 - 1 = 
// 2 3 4 5 6 7 8 = 4 - 1 = 3

// 3 = 7 - 3