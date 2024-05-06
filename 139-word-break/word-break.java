class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] visited = new boolean[s.length() + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            if (currentIndex == s.length()) {
                return true;
            }

            for (int length = 1; length + currentIndex <= s.length(); length++) {
                if (visited[currentIndex + length]) {
                    continue;
                }
                if (set.contains(s.substring(currentIndex, currentIndex + length))) {
                    visited[currentIndex + length] = true;
                    queue.offer(currentIndex + length);
                }
            }
        }
        return false;
    }
}