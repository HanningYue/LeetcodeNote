class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> set = new HashSet<>(wordList);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                StringBuilder sb = new StringBuilder(current);
                if (current.equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < current.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        if (set.contains(sb.toString())) {
                            queue.add(sb.toString());
                            set.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(j, current.charAt(j));
                }
            }
        }
        return 0;
    }
}