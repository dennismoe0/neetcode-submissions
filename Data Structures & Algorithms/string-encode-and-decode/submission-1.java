class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            int length = strs.get(i).length();
            // Potentially add a char after so show it's done, to triple check
            sb.append(length).append("#").append(strs.get(i)).append("|");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> words = new ArrayList<>();
        int num = -1;
        StringBuilder numberBuilder = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();

        // Need to find hashtag, then check digits before.
        // up to 3 digits, add checks for above 200 etc

        for (int i = 0; i < str.length(); i++) {
            // Curennt char in string
            char c = str.charAt(i);

            if (c == '#') {
                // Backwards 3 steps max
                for (int j = i-1; j>= 0 && j >= i - 3; j--) {

                    char prev = str.charAt(j);

                    // If it's not a digit
                    if (!Character.isDigit(prev)) {
                        break;
                    }
                    numberBuilder.insert(0, str.charAt(j));
                }
                // e.g. 42
                num = Integer.parseInt(numberBuilder.toString());
            } 
            if (num >= 0 && num < 200) {
                for (int n = 0; n < num; n++) {
                    wordBuilder.append(str.charAt(i+n+1));
                }
                words.add(wordBuilder.toString());
                i += num + 1;
                // Clear everything for the next word?
                num = -1;
                wordBuilder.setLength(0);
                numberBuilder.setLength(0);
            }
        }

        return words; 
    }
}
