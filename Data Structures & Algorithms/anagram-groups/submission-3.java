class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> anagramMap = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
        // word needs to be sorted first
        // Extract word from list
        String word = strs[i];
        // Divide into chars
        char[] charArray = word.toCharArray();
        // sort alphabetically. E.g.  "Cat" -> "act"
        java.util.Arrays.sort(charArray);
        // make string out of sorted anagram
        String anagramSorted = new String(charArray);

        // if map contains key "act"
        if (anagramMap.containsKey(anagramSorted) == true) {
            // add string to preexisting list
            anagramMap.get(anagramSorted).add(word);
        }
        if (anagramMap.containsKey(anagramSorted) != true) {
            // Make new list and add the string, key is sorted anagram
            anagramMap.put(anagramSorted, new ArrayList<>());
            anagramMap.get(anagramSorted).add(word);
        }
        
    }
   
    List<List<String>> anagrams = new ArrayList<>();

    // Make a list of the values
    // ad each list (group of anagrams) to the anagrams list
    for (List<String> anagramList : anagramMap.values()) {
        anagrams.add(anagramList);
    }
    return anagrams;

    }
}