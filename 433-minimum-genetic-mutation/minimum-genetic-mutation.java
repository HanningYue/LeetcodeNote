class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] mutation = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        for (String gene : bank) {
            set.add(gene);
        }
        if (!set.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) {
                    return step;
                }

                StringBuilder sb = new StringBuilder(current);
                for (int j = 0; j < sb.length(); j++) {
                    char original = sb.charAt(j);
                    for (char c : mutation) {
                        sb.setCharAt(j, c);
                        if (set.contains(sb.toString())) {
                            queue.offer(sb.toString());
                            set.remove(sb.toString());
                        }
                        sb.setCharAt(j, original);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}