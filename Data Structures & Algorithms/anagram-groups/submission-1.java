class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> groups = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
        // word needs to be sorted first
        // Extract word from list
        String word = strs[i];
        // Divide into chars
        char[] charArray = word.toCharArray();
        // sort alphabetically. E.g.  "Cat" -> "act"
        java.util.Arrays.sort(charArray);
        // make string out of sorted anagram
        String key = new String(charArray);
        
        groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());
    }
}