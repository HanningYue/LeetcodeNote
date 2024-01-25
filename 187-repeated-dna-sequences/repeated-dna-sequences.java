class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;

            }
        }
        int base = 4, length = 10;
        int highestDigit = (int)Math.pow(base, length - 1);
        int slow = 0, fast = 0;
        int rollingHash = 0;

        Set<Integer> seen = new HashSet<>();
        Set<String> stringSet = new HashSet<>();
        while (fast < nums.length) {
            rollingHash = rollingHash * base + nums[fast];
            if (fast - slow + 1 == length) {
                if (seen.contains(rollingHash)) {
                    stringSet.add(s.substring(slow, fast + 1));
                } else {
                    seen.add(rollingHash);
                }
                rollingHash = rollingHash - highestDigit * nums[slow];
                slow++;
            }
            fast++;
        }
        for (String sub : stringSet) {
            result.add(sub);
        }
        return result;
    }
}