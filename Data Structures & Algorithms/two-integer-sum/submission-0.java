class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int arr[] = null;
        for(int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                if (nums[i] + nums[j] == target) {
                    arr = new int[] {i, j};
                    break;
                }
                if (arr != null) {
                    break;
                }
            }
        }

        return arr;
    }
}
