class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> set = new HashSet<>(wordList);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return step;
                }

                StringBuilder sb = new StringBuilder(currentWord);
                for (int j = 0; j < currentWord.length(); j++) {
                    char original = currentWord.charAt(j);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        if (set.contains(sb.toString())) {
                            set.remove(sb.toString());
                            queue.offer(sb.toString());
                        }
                    }
                    sb.setCharAt(j, original);
                }
            }
            step++;
        }
        return 0;
    }
}