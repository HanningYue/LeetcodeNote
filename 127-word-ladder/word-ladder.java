class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return step;
                }

                StringBuilder sb = new StringBuilder(current);
                for (int j = 0; j < current.length(); j++) {
                    char original = current.charAt(j);

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