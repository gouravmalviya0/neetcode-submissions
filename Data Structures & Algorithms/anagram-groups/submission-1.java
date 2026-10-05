class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> list = new HashMap<>();

        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (!list.containsKey(key)) {
                list.put(key, new ArrayList<>());
            }
            list.get(key).add(s);
        }
        return new ArrayList<>(list.values());

    }
}
