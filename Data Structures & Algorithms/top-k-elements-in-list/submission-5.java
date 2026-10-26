class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
    /**

    Iterate through
    put ionto hashmap
    increase value for each element
    
    elements.computeIfAbsent(key, k -> new ArrayList<>()).add(number);

    */

    // sort array?
    Arrays.sort(nums);
    // now e.g. 1,2,2,3
    
    // make a map with an int as key (the number) and value is a list. list adds per number, so 3 sevens: <7, [7,7,7]>, size/length = 3.
    // split list instead and just count after sort? size of splits? after sort
    // if number is not the same as last number, split, count? maybe extra step hashmap does the same


    // Key (e.g. 7) is a number like 7, value is the occurance 
    Map<Integer, Integer> numero = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int num : nums) {
        numero.put(num, numero.getOrDefault(num, 0) + 1);
    }
    // Now we should have a map like 1=1, 2=2, 3=3 
    // Need to identify the largest occurence, and print all k of them.
    // if k = 2, it means that there will be 2 numbers to print, which will be the two largest. ALWAYS a match according to rules.
    // So identify biggest value, extract k keys, return int[] of those.

    // Now we have the biggest value, e.g. 3
    // entrySet returns set of pairs in the map. Stream makes it accesible "on conveyor". filter each entry, it needs to equals biggestValue, transform it (map()) => take each pair (key value) and only take the key (getKey). Uses all of the transformed data in stream and sets up a list.

    // ive misunderstood the entire question
    // k most frequent, not those above a threshold of k occurences. so return an int array of the 2 most frequent, even if they occur 2 and 50 times. 


    // NEED TO CHANGE THIS TO TAKE THE first, then second, ... most frequent (based on k). Remove the previous one (key removal), then find the next, add to int array each time.
    int[] keys = new int[k]; 
    numero.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), k)).map(entry -> entry.getKey()).mapToInt(Integer::intValue).toArray();
    for (int i = 0; i < k; i++) {

        // NEEDS TO BE CHANGED TO FIND BIGGEST VALUE! Get back the foor loop? Collections.max(numero.values());
        keys[i] = numero.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(entry -> entry.getKey())
        .orElse(-1);
        
        // need to remove the biggest key after retrieval.
        numero.remove(keys[i]);

    }

    // Can probably combine the for loops into one
    return keys;
    }
}
