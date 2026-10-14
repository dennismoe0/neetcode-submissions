class Solution {
    public boolean isAnagram(String s, String t) {
    // If they're not the same length then fuck off
    if (s.length() != t.length()) {
        return false;
    }
    // add chars to a list, probably unecessary
    List<Character> charS = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
        charS.add(s.charAt(i));
    }
    // add chars to a list, probably unecessary
    List<Character> charT = new ArrayList<>();
    for (int i = 0; i < t.length(); i++) {
        charT.add(t.charAt(i));
    }
    // Sort lists alphabetically.
    charS.sort(null);
    charT.sort(null);

    // Compare lists, always undercase so should be the same now.
    for (int i = 0; i < s.length(); i++) {
        if (charS.get(i) != charT.get(i)) {
            return false;
        }
    }
    // If identical, return true:
    return true;
    }
}
