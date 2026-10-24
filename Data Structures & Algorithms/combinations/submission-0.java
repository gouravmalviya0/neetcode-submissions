class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combine(n, 1, k, new ArrayList<>());
    }

    public List<List<Integer>> combine(int n, int index, int k, List<Integer> list) {
        if (n < index) {
            List<List<Integer>> ans = new ArrayList<>();
            if (list.size() == k) {
                ans.add(new ArrayList<>(list));
            }
            return ans;
        }

        list.add(index);
        List<List<Integer>> left = combine(n, index+1, k, list);

        list.remove(list.size()-1);
        List<List<Integer>> right = combine(n, index+1, k, list);

        left.addAll(right);

        return left;
    }
}