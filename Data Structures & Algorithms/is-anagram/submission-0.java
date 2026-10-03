class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;

        int ch[] = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            ch[s.charAt(i) - 'a']++;
            ch[t.charAt(i) - 'a']--;
        }
        boolean isAnagram = true;
        for(int i=0; i<26;i++) {
            if(ch[i] != 0) {
                isAnagram = false;
                break;
            }
        }

        return isAnagram;
    }
}
