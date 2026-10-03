class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int arr[]= null;
        for(int i=0;i<n;i++) {
            if(map.containsKey(target - nums[i])) {
                arr = new int[] {map.get(target - nums[i]), i};
                break;
            }
            map.put(nums[i], i);
        }

        return arr;
    }
}
