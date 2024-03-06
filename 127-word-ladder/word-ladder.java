class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return result;
                }
                StringBuilder sb = new StringBuilder(current);
                for (int j = 0; j < sb.length(); j++) {
                    char jChar = sb.charAt(j);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        if (set.contains(sb.toString())) {
                            set.remove(sb.toString());
                            queue.offer(sb.toString());
                        }
                    }
                    sb.setCharAt(j, jChar);
                }
            }
            result++;
        }
        return 0;
    }
}