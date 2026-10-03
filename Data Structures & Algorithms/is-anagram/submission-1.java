class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;

        List<Character> set = new ArrayList<>();
        for(int i = 0;i<s.length();i++) {
            set.add(s.charAt(i));
        }
        for(int i=0;i<t.length();i++) {
            set.remove(new Character(t.charAt(i)));
        }
        return set.isEmpty();
    }
}
