class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        List<List<Integer>> ans = findAllSubset(nums, 0, list);
        int sum = 0;
        for(List<Integer> subList : ans) {
            if(subList.isEmpty()) {
                continue;
            }

            if(subList.size() == 1) {
                sum += subList.get(0);
                continue;
            }
            int xor = 0;
            for(int i=0;i<subList.size();i++) {
                xor ^= subList.get(i);
            }
            sum += xor;
        }

        return sum;
    }

    public List<List<Integer>> findAllSubset(int[] nums, int index, List<List<Integer>> list) {
        if(nums.length == index) {
            return list;
        }

        int num = nums[index];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++) {
            List<Integer> l1 = new ArrayList<>(list.get(i));
            l1.add(num);
            ans.add(l1);
        }

        List<List<Integer>> left = findAllSubset(nums, index+1, ans);
        List<List<Integer>> right = findAllSubset(nums, index+1, list);
        
        left.addAll(right);

        return left;
    }
}