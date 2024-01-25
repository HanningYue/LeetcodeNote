class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
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

        Set<Integer> seen = new HashSet<>();
        Set<String> set = new HashSet<>();
        int length = 10, base = 4, highestDigit = (int)Math.pow(base, length - 1);
        int hashing = 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            hashing = base * hashing + nums[fast];
            if (fast - slow + 1 == length) {
                if (seen.contains(hashing)) {
                    set.add(s.substring(slow, fast + 1));
                } else {
                    seen.add(hashing);
                }
                hashing = hashing - nums[slow] * highestDigit;
                slow++;
            }
            fast++;
        }
        return new ArrayList<>(set);
    }
}