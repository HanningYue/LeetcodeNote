class Solution {
    public String rankTeams(String[] votes) {
        int length = votes[0].length();

        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (String vote : votes) {
                char current = vote.charAt(i);
                map.putIfAbsent(current, new int[length]);
                map.get(current)[i]++;
            }
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < length; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}