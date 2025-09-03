
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int size = sequence.length;
        
        int l = 0, r = 0;
        int sum = sequence[l];
        
        int minLen = size + 1;
        int[] minLR = new int[2];
        
        while(l < size && r < size) {
            if (sum == k) {
                if (r - l + 1 < minLen) {
                    minLR[0] = l;
                    minLR[1] = r;
                    minLen = r - l + 1;
                }
                
                sum -= sequence[l];
                l++;
            }
            else if (sum < k) {
                r++;
                if (r < size)
                    sum += sequence[r];
            }
            else {
                sum -= sequence[l];
                l++;
            }
        }
        
        return minLR;
    }
}
