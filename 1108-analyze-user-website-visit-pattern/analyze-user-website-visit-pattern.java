class Pair {
    int time;
    String web;
    public Pair(int time, String web) {
        this.web = web;
        this.time = time;
    }
}
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new ArrayList<Pair>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        for (List<Pair> list : map.values()) {
            Collections.sort(list, (a, b) -> a.time - b.time);
        }
    
        Map<String, Set<String>> sequenceMap = new HashMap<>();
        
        for (String user : map.keySet()) {
            List<Pair> history = map.get(user);
            if (history.size() >= 3) {
                Set<String> visited = new HashSet<>();
                for (int i = 0; i < history.size(); i++) {
                    for (int j = i + 1; j < history.size(); j++) {
                        for (int k = j + 1; k < history.size(); k++) {
                            String sequence = history.get(i).web + " " + history.get(j).web + " " + history.get(k).web;
                            if (visited.contains(sequence)) {
                                continue;
                            }
                            visited.add(sequence);
                            sequenceMap.putIfAbsent(sequence, new HashSet<>());
                            sequenceMap.get(sequence).add(user);
                        }
                    }
                }
            }
        }

        String maxSequence = "";
        int maxCount = 0;
        for (String sequence : sequenceMap.keySet()) {
            int count = sequenceMap.get(sequence).size();
            if (count > maxCount || (count == maxCount && sequence.compareTo(maxSequence) < 0)) {
                maxCount = count;
                maxSequence = sequence;
            }
        }

        return Arrays.asList(maxSequence.split(" "));
    }
}