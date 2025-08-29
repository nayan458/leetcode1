// long n_even = (n / 2), n_odd = (n - n_even);
// long m_even = (m / 2), m_odd = (m - m_even);

// return ((n_odd * m_even) + (n_even * m_odd));
class Solution {
    public long flowerGame(int n, int m) {
        
        return (long)((long)n * (long)m)/2;
    }
}