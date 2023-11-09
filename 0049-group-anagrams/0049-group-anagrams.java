/**
Given String[], return List<List<String>>, so for each anagram, we need to have a List<String>
1. Iterate String[], for each String inside, construct char[]
2. Sort the char[], declear a new String object of the sorted char[]
3. Declear a Map, for each sorted anagram, we need a new ArrayList<String>
4. IMPORTANT, because anagrams are IDENTICAL after sorted, so we can get and add
5. Add current unsorted str to list
6. Return an arrayList of map.values()
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] strChar = str.toCharArray();
            
            Arrays.sort(strChar);
            
            String sortedStr = new String(strChar);
            
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}