class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIdx = 0;

        while (startIdx < words.length) {
            int totalChars = words[startIdx].length();
            int last = startIdx + 1;

            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                } else {
                    totalChars += 1 + words[last].length();
                    last++;
                }
            }

            int gaps = last - startIdx - 1;
            StringBuilder sb = new StringBuilder();
            if (last == words.length || gaps == 0) {
                for (int i = startIdx; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            }
            else {
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;
                for (int i = startIdx; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    for (int j = 0; j < spaces + (i - startIdx < rest ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[last - 1]);
            }
            result.add(sb.toString());
            startIdx = last;
        }
        return result;
    }
}