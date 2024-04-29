class Pair {
    int timestamp;
    String website;    
    public Pair(int timestamp, String website) {
        this.timestamp = timestamp;
        this.website = website;
    }
}

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> userMap = new HashMap<>();

        // Collect all visits for each user
        for (int i = 0; i < username.length; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        // Sort visits for each user by timestamp
        for (List<Pair> visits : userMap.values()) {
            Collections.sort(visits, (a, b) -> Integer.compare(a.timestamp, b.timestamp));
        }

        // Generate sequences and count unique users per sequence
        Map<String, Set<String>> sequenceUserMap = new HashMap<>();
        for (String user : userMap.keySet()) {
            List<Pair> visits = userMap.get(user);
            // Generate all combinations of 3-sequence patterns for each user
            if (visits.size() >= 3) {
                Set<String> seen = new HashSet<>(); // To avoid duplicate sequences for the same user
                for (int i = 0; i < visits.size(); i++) {
                    for (int j = i + 1; j < visits.size(); j++) {
                        for (int k = j + 1; k < visits.size(); k++) {
                            String seq = visits.get(i).website + " " + visits.get(j).website + " " + visits.get(k).website;
                            if (!seen.contains(seq)) {
                                seen.add(seq);
                                sequenceUserMap.putIfAbsent(seq, new HashSet<>());
                                sequenceUserMap.get(seq).add(user);
                            }
                        }
                    }
                }
            }
        }

        // Determine the sequence with the maximum number of unique users
        String maxSequence = "";
        int maxCount = 0;
        for (String sequence : sequenceUserMap.keySet()) {
            int count = sequenceUserMap.get(sequence).size();
            if (count > maxCount || (count == maxCount && sequence.compareTo(maxSequence) < 0)) {
                maxCount = count;
                maxSequence = sequence;
            }
        }

        // Return the result as a list of websites
        return Arrays.asList(maxSequence.split(" "));
    }
}
