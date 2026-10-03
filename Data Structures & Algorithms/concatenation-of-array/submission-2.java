class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int bigNum[] = new int[n*2];
        for(int i= 0; i<n;i++) {
            bigNum[i] = nums[i];
            bigNum[i+n] = nums[i];
        }
        return bigNum;
    }
}