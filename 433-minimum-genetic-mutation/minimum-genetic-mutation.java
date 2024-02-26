class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(endGene)) {
            return -1;
        }

        char[] mutation = new char[]{'A', 'C', 'T', 'G'};
        Queue<String> queue = new LinkedList<>();
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
                for (int j = 0; j < current.length(); j++) {
                    char original = current.charAt(j);
                    for (char c : mutation) {
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
        return -1;
    }
}