class Solution {
    public int mySqrt(int x) {
        long n = (long) x;
        long start = 1;
        long end = x >= 2 ? x/2 : x;

        while (start <= end) {
            long mid = start + (end-start)/2;
            if(mid*mid == x) {
                return (int)mid;
            } else if (mid*mid > x) {
                end = mid - 1;
            }  else {
                start = mid + 1;
            }
        }

        return (int)end;
    }
}