class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0, right = 0;
        int sum = 0; 

        int bestStart = 0, bestEnd = 0;
        int bestLen = Integer.MAX_VALUE;

        while (true) {
            if (sum == k) {
                int len = right - left; 
                if (len < bestLen || (len == bestLen && left < bestStart)) {
                    bestLen = len;
                    bestStart = left;
                    bestEnd = right - 1;
                }
                sum -= sequence[left++];
            }
            else if (sum > k) {
                sum -= sequence[left++];
            }
            else { // sum < k
                if (right == n) break;
                sum += sequence[right++];
            }
        }
        if (bestLen == Integer.MAX_VALUE) return new int[]{0, 0};

        return new int[]{bestStart, bestEnd};
    }
}
