class Solution {
    public int removeElement(int[] nums, int val) {
        int s = 0;
        int e = 0;
        while (e < nums.length) {
            if (nums[e] == val) {
                e++;
            } else {
                if (nums[s] == val) {
                    int t = nums[s];
                    nums[s] = nums[e];
                    nums[e]=t;
                }
                s++;
                e++;
            }
        }
        return s;
    }
}